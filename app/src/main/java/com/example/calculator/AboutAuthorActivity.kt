package com.example.calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityAboutAuthorBinding

class AboutAuthorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutAuthorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutAuthorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { startActivity(Intent(this@AboutAuthorActivity, MainActivity::class.java)) }
    }
}