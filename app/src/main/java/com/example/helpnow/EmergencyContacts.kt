package com.example.helpnow

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EmergencyContacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emergency_contacts)

        val enterNum1: EditText = findViewById(R.id.editNum1)
        val enterNum2: EditText = findViewById(R.id.editNum2)
        val enterNum3: EditText = findViewById(R.id.editNum3)

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