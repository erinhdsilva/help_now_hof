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

        val enterNum1: EditText = findViewById(R.id.emer1)
        val enterNum2: EditText = findViewById(R.id.emer2)
        val enterNum3: EditText = findViewById(R.id.emer3)


        }
    }