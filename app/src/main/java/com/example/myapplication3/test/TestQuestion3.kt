package com.example.myapplication3.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.R
import com.example.myapplication3.SubquestionsAndAnswers

class TestQuestion3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_question3)

        val id = intent.getIntExtra("id", 0)
        val firstButton = findViewById<Button>(R.id.button4)
        firstButton.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            if (id == 13) {
                intent.putExtra("button", 133)
            } else {
                intent.putExtra("button", 212)
            }
            intent.putExtra("text", "\uD83D\uDEF4 => \uD83D\uDEB4 (самокатчик как велосипедист)")
            startActivity(intent)
            finish()
        }
        val secondButton = findViewById<Button>(R.id.button5)
        secondButton.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            if (id == 13) {
                intent.putExtra("button", 133)
            } else {
                intent.putExtra("button", 214)
            }
            intent.putExtra("text", "\uD83D\uDEF4 => \uD83D\uDEF5 (самокатчик как водитель мопеда)")
            startActivity(intent)
            finish()
        }

        val thirdButton = findViewById<Button>(R.id.button6)
        thirdButton.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            if (id == 13) {
                intent.putExtra("button", 133)
            } else {
                intent.putExtra("button", 215)
            }
            intent.putExtra("text", "\uD83D\uDEF4 => \uD83C\uDFCD (самокатчик как водитель мотоцикла)")
            startActivity(intent)
            finish()
        }
    }

}