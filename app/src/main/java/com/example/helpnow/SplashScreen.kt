package com.example.helpnow

// SplashScreenActivity.kt
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            // Start your main activity here
            val intent = Intent(this, WelcomePage::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}

