package com.example.helpnow

import android.os.Bundle
import android.text.TextUtils // For checking empty strings (optional)
import android.view.View // Required for click listener
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat // For setting system bars behavior (optional)

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display (adjust for your requirements)
        enableEdgeToEdge()

        setContentView(R.layout.activity_login)

        // Fetch references to views after setting content view
        val enterEmail: EditText = findViewById(R.id.emailEditText)
        val enterPass: EditText = findViewById(R.id.passwordEditText)

        // Access EditText contents within a button click listener
        val loginButton = findViewById<View>(R.id.loginButton) // Replace with your button's ID
        loginButton.setOnClickListener {
            val email = enterEmail.text.toString().trim() // Trim leading/trailing whitespace

            // Check for empty email (optional)
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Exit the listener if email is empty
            }

            // Implement your login logic here (e.g., validation, authentication)
            val password = enterPass.text.toString()
            // ... (handle login)

            Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show() // Feedback
        }
    }
}
