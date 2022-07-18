package com.example.myapplication3.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.R

class TestInfo1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_info1)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, TestQuestion3::class.java)
            intent.putExtra("button", 1)
            startActivity(intent)
            finish()
        }
    }
}