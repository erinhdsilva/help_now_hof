package com.example.helpnow

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PasswordActivity : AppCompatActivity() { // Rename class for clarity

    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var createPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_password)

        passwordEditText = findViewById(R.id.pass) // Assuming IDs exist
        confirmPasswordEditText = findViewById(R.id.confirm_pass_text)
        createPasswordButton = findViewById(R.id.pass_btn)

        // Handle system bars (optional, adjust padding logic if needed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        createPasswordButton.setOnClickListener {
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            // Validate password (length, complexity, etc.)
            if (isValidPassword(password)) {
                if (password == confirmPassword) {
                    // Save password (implement your storage mechanism)
                    Toast.makeText(this, "Password created successfully!", Toast.LENGTH_SHORT).show()
                    // Go to next activity or perform other actions
                } else {
                    Toast.makeText(this, "Passwords don't match!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Invalid password format!", Toast.LENGTH_SHORT).show()
                // Provide password format guidelines
            }
        }
    }

    private fun isValidPassword(password: String): Boolean {
        // Implement password validation logic (e.g., minimum length, character types)
        // You can use libraries for password strength or create custom rules
        return password.length >= 8 && // Adjust as needed
                password.any { it.isDigit() } && // Check for at least one digit
                password.any { it.isUpperCase() }  // Check for at least one uppercase letter
    }
}
