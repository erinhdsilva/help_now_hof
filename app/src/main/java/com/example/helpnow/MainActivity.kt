package com.example.helpnow

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.helpnow.databinding.ActivityMainBinding
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager // Get FragmentManager

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> fragmentManager.beginTransaction()
                    .replace(R.id.main, HomeFragment()) // Replace with your fragment container ID
                    .addToBackStack(null) // Optional: Add transaction to back stack for navigation
                    .commit()
                R.id.yourinfo -> fragmentManager.beginTransaction()
                    .replace(R.id.main, ProfileFragment()) // Assuming YourInfo is the correct class
                    .addToBackStack(null)
                    .commit()
                else -> {
                    // Handle unexpected item selection (optional)
                }
            }
            true // Consumed the event (optional based on your usage)
        }



        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun replacefragment(fragment: Fragment) {
            val fragmentManager =supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout,fragment)
            fragmentTransaction.commit()
        }
    }


}