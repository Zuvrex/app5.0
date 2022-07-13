package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class QuestionsList : AppCompatActivity() {
    val db = DataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_of_questions)

        // В стэк сохраняются ID вопросов из ветки, для того чтобы можно было вернуться назад
        val stack = ArrayList<Int>()

        db.open()
        val listView = findViewById<ListView>(R.id.listView)    // спиок на экране

        stack.add(intent.getIntExtra("button", 0))  // записываем в стэк ID кнопки с предыдущего Activity
        var qu_table = db.list_of_questions(stack.last())   // список вопросов для этой кнопки (таблица)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question)    // помещаем вопросы в список на экране

        // Сдедующий код срабатывает при нажатии на вопрос
        listView.setOnItemClickListener{parent, view, position, id ->
            // Если в таблице есть ответ на вопрос, переходим на Activity с ответом и передаем туда нужные тексты из БД
            // Иначе, выводим список подвопросов для воопроса, на который нажали
            if (qu_table.main_text[position] != "") {
                val intent = Intent(this, AnswerActivity::class.java)
                intent.putExtra("question", qu_table.question[position])    // тексты для нужного вопроса передаем в следующий Activity (т. е. на страницу с ответом)
                intent.putExtra("short_ans", qu_table.short_ans[position])
                intent.putExtra("main_text", qu_table.main_text[position])
                intent.putExtra("link", qu_table.link[position])
                intent.putExtra("link_text", qu_table.link_text[position])
                startActivity(intent)
            } else {
                stack.add(qu_table.ID[position])    // В стэк записываем ID вопроса
                qu_table = db.list_of_questions(stack.last())   // Подвопросы для этого вопроса
                listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question // Помещаем вопросы в список на экране
                )
            }
        }

        // кнопка для возвращения назад
        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            stack.removeLast()  // удаляется последний ID из стэка
            // Если стэк пуст, завершаем работу Activity и возвращаемся на предыдущий Activity (т. е. главную страницу)
            // Иначе, возвращаемся к предыдущему вопросу
            if (stack.isEmpty()) {
                this.finish()
            } else {
                qu_table = db.list_of_questions(stack.last())
                listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}