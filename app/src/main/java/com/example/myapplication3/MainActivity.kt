package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val db = DataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db.open()   // открываем базу данных для работы с ней
//        db.execute(DROP_TABLE_NODE)
//        db.execute(DROP_TABLE_QUESTION)
//        db.execute(CREATE_TABLE_QUESTION)
//        db.execute(CREATE_TABLE_NODE)
//        db.execute(FILL_QUESTION)
//        db.execute(FILL_NODE)
        val button1 = findViewById<Button>(R.id.button_for_car)
        val button2 = findViewById<Button>(R.id.button_for_kik)
        val button3 = findViewById<Button>(R.id.button_for_important)

        button1.setOnClickListener {
            val intent = Intent(this, QuestionsList::class.java)
            intent.putExtra("button", 1)    // номер кнопки передается в следующий Activity (т. е. список вопросов), чтобы можно было понять, какая кнопка была нажата, и вывести нужные вопросы из базы
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

    // закрываем базу при окончании работы activity
    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}