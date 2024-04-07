package com.example.helpnow

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.helpnow.Buttons

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val enterEmail: EditText = findViewById(R.id.emailEditText)
        val enterPass: EditText = findViewById(R.id.passwordEditText)

        val loginButton = findViewById<View>(R.id.loginButton)
        loginButton.setOnClickListener {
            val intent = Intent(this, Buttons::class.java)
            startActivity(intent)
            finish()
            val email = enterEmail.text.toString().trim()
            val password = enterPass.text.toString()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Hardcoded validation of email and password

            if (email == "example@example.com" && password == "123456") {
                // If credentials match, proceed to next activity
//                val intent = Intent(this, Buttons::class.java)
//                startActivity(intent)
//                finish()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
