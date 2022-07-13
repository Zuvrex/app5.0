package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class QuestionsList : AppCompatActivity() {
    val db = DataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_of_questions)

        db.open()
        val listView = findViewById<ListView>(R.id.listView)

        var qu_table = db.list_of_questions(intent.getIntExtra("button", 0))
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question)

        listView.setOnItemClickListener{parent, view, position, id ->
            if (qu_table.answer[position] != 0) {
                val intent = Intent(this, ACTIVITY_NAMES[qu_table.answer[position]])
                startActivity(intent)
            } else {
                qu_table = db.list_of_questions(qu_table.ID[position])
                listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}