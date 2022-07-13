package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    val db = DataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db.open()
        val button1 = findViewById<Button>(R.id.button_for_car)
        val button2 = findViewById<Button>(R.id.button_for_kik)
        val button3 = findViewById<Button>(R.id.button_for_important)

        button1.setOnClickListener {
            val intent = Intent(this, QuestionsList::class.java)
            intent.putExtra("button", 1)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, QuestionsList::class.java)
            intent.putExtra("button", 2)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, QuestionsList::class.java)
            intent.putExtra("button", 3)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}