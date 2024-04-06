package com.example.helpnow

import android.Manifest
import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.IBinder
import android.telephony.SmsManager
import androidx.annotation.Nullable
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MyService : Service() {

    private val FOREGROUND_ID = 115 // Notification ID
    private val CHANNEL_ID = "MY_ID" // Notification channel ID

    private var isRunning = false
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val smsManager: SmsManager = SmsManager.getDefault()
    private var myLocation = "Location not available"

    override fun onCreate() {
        super.onCreate()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Check if location permissions are granted
        if (checkLocationPermissions()) {
            requestLocationUpdates()
        }
    }

    private fun checkLocationPermissions(): Boolean {
        return (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
    }

    private fun requestLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        val addOnSuccessListener = fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                myLocation = location?.let {
                    "http://maps.google.com/maps?q=loc:${location.latitude},${location.longitude}"
                } ?: "Unable to Find Location :("
            }
    }

    @Nullable
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action.equals("STOP", ignoreCase = true)) {
            if (isRunning) {
                stopForeground(true)
                stopSelf()
            }
        } else {
            // Create notification for foreground service
            createNotification()

            isRunning = true
        }
        return START_NOT_STICKY
    }

    @SuppressLint("ForegroundServiceType")
    private fun createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "WSecure Service",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notification for WSecure service"
            }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("WSecure")
            .setContentText("Click the button to Send the Emergency Alert")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(FOREGROUND_ID, notification)
    }

    // Function to send SMS (can be called from other parts of your app)
    fun sendSMS() {
        val sharedPreferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
        val emergencyContactNumber = sharedPreferences.getString("ENUM", null)
        if (emergencyContactNumber.isNullOrEmpty().not()) {
            // ... send SMS logic ...
        }
    }
}