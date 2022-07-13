package com.example.myapplication3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnswerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answer_page)

        //  Кнопка для перехода к странице контактов.
        val button: ImageView = findViewById(R.id.imageView)
        button.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }

        val question = findViewById<TextView>(R.id.question_id)
        val short_ans = findViewById<TextView>(R.id.short_ans_id)
        val main_text = findViewById<TextView>(R.id.main_text_id)
        val link_text = findViewById<TextView>(R.id.link_id)

        // Выводим тексты для нужного вопроса, взятые с предыдущего Activity (список вопросов), в нужные поля на экране
        question.text = intent.getStringExtra("question")
        short_ans.text = intent.getStringExtra("short_ans")
        main_text.text = intent.getStringExtra("main_text")
        link_text.text = intent.getStringExtra("link_text")

        // Выводим ссылку.
        link_text.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra("link")))
            startActivity(i)
        }

        // Завершаем работу Activity при нажатии кнопки назад
        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            this.finish()
        }
    }
}