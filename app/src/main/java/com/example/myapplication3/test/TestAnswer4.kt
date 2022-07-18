package com.example.myapplication3.test

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.R

class TestAnswer4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_answer4)
        var button = findViewById<Button>(R.id.button10)
        button.setOnClickListener {
            finish()
        }
    }
}