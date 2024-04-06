package com.example.helpnow

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WelcomePage : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_page)

        val registerButton = findViewById<Button>(R.id.register)

        // Corrected click listener using lambda expression (preferred)
        registerButton.setOnClickListener {
            val intent = Intent(this@WelcomePage, RegisterActivity::class.java) // Use context explicitly
            startActivity(intent)
        }

        val loginButton = findViewById<Button>(R.id.login)

        // Corrected click listener using lambda expression (preferred)
        loginButton.setOnClickListener {
            val intent = Intent(this@WelcomePage, LoginActivity ::class.java) // Use context explicitly
            startActivity(intent)
        }


        // Alternative with anonymous inner class (less preferable)
//        registerButton.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                val intent = Intent(this@WelcomePage, Register::class.java)
//                startActivity(intent)
//            }
//        })
    }
}
