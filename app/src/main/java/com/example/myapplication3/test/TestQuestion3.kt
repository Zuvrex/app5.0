package com.example.myapplication3.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.R

class TestQuestion3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_question3)

        val firstButton = findViewById<Button>(R.id.button4)
        firstButton.setOnClickListener {
            val intent = Intent(this, TestAnswer2::class.java)
            intent.putExtra("button", 1)
            startActivity(intent)
            finish()
        }
        val secondButton = findViewById<Button>(R.id.button5)
        secondButton.setOnClickListener {
            val intent = Intent(this, TestAnswer3::class.java)
            intent.putExtra("button", 2)
            startActivity(intent)
            finish()
        }

        val thirdButton = findViewById<Button>(R.id.button6)
        thirdButton.setOnClickListener {
            val intent = Intent(this, TestAnswer4::class.java)
            intent.putExtra("button", 3)
            startActivity(intent)
            finish()
        }
    }

}