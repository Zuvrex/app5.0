package com.example.myapplication3.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.R
import com.example.myapplication3.SubquestionsAndAnswers

class TestQuestion1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_question1)
        val id = intent.getIntExtra("id", 0)
        val noButton = findViewById<Button>(R.id.button)
        noButton.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            if (id == 13) {
                intent.putExtra("button", 132)
            } else {
                intent.putExtra("button", 211)
            }
            intent.putExtra("text", "\uD83D\uDEF4 => \uD83D\uDEB6 (самокатчик как пешеход)")
            startActivity(intent)
            finish()
        }
        val yesButton = findViewById<Button>(R.id.button2)
        yesButton.setOnClickListener {
            val intent = Intent(this, TestQuestion2::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
            finish()
        }
    }
}