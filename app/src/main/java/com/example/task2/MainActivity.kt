package com.example.task2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set button click listener
        binding.button.setOnClickListener {
            val userName = binding.editTextText.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()

            when {
                userName.isEmpty() -> {
                    Toast.makeText(this, "Username is Empty", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show()
                }
                password.length < 8 -> {
                    Toast.makeText(this, "Password must be more than 8 characters", Toast.LENGTH_SHORT).show()
                }
                !password.matches(Regex(".*[A-Za-z].*")) || !password.matches(Regex(".*\\d.*")) -> {
                    Toast.makeText(this, "Password must contain both letters and numbers", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val intent = Intent(this, SecondryActivity::class.java)
                    startActivity(intent)


                    finish()
                }
            }
        }

        // Edge-to-edge support
        enableEdgeToEdge()

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
