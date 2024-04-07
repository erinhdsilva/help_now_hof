package com.example.helpnow

import android.Manifest

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.helpnow.databinding.ActivityButtonsBinding
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar

class Buttons : AppCompatActivity() {
    private lateinit var binding: ActivityButtonsBinding

    private val manager: SmsManager = SmsManager.getDefault()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button12.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            ) {
                // Permission is granted, proceed to send SMS with location
                getLocationAndSendSMS()
            } else {
                // Request permissions if not granted
                multiplePermissions.launch(
                    arrayOf(
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                )
            }
            val num1="8197850777"
            val num2="9049696447"
            val num3="9302541487"
            val location = "http://maps.google.com/maps?q=loc:26.800425,81.023964"
            manager.sendTextMessage(num1, null, "Im in Trouble!\nSending My Location :$location", null, null)
            manager.sendTextMessage(num2, null, "Im in Trouble!\nSending My Location :$location", null, null)
            manager.sendTextMessage(num3, null, "Im in Trouble!\nSending My Location :$location", null, null)

        }

        binding.homebtn.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
//    private fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(binding.home.id, fragment)
//            .commit()
//    }

    private fun showPermissionSnackbar(permission: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content), "Permission Must Be Granted!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Grant Permission") {
            multiplePermissions.launch(arrayOf(permission))
            snackbar.dismiss()
        }
        snackbar.show()
    }


    private val multiplePermissions = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result: Map<String, Boolean> ->
        result.entries.forEach { entry ->
            if (!entry.value) {
                showPermissionSnackbar(entry.key)
            }
        }
    }
    // Your other functions...

//    fun startServiceV(view: View) {
//
//
//    }

    private fun getLocationAndSendSMS() {
        // Check if location permissions are granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            // Permissions not granted, return or request permissions again
            return
        }

        // Get the location using any available location provider
//        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//        fusedLocationClient.lastLocation
//            .addOnSuccessListener { location: Location? ->
//                // Got last known location. In some rare situations, this can be null.
//                location?.let {
//                    // Location obtained successfully, now you can send the SMS with location coordinates
//                    sendSMSWithLocation(location.latitude, location.longitude)
//                }
//            }
//            .addOnFailureListener { e ->
//                // Handle failure to get location
//                Snackbar.make(findViewById(android.R.id.content), "Failed to get location: ${e.message}", Snackbar.LENGTH_LONG).show()
//            }
    }

    private fun sendSMSWithLocation(latitude: Double, longitude: Double) {
         // Construct SMS message with location
        val message = "Emergency! Need help at location: Latitude=$latitude, Longitude=$longitude"
        // Now you can send SMS with this message
    }
}
