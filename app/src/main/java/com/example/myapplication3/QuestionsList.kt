package com.example.myapplication3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class QuestionsList : AppCompatActivity() {
//    val db = DataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_of_questions)

//        db.open()
//        var qu_table = db.list_of_questions(1)
//
//        val listView = findViewById<ListView>(R.id.listView)
//        listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question)
//
//        listView.setOnItemClickListener{parent, view, position, id ->
//            qu_table = db.list_of_questions(qu_table.ID[position])
//            listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question)
//        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        db.close()
//    }
}