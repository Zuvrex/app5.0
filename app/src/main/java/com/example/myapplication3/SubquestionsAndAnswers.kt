package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class SubquestionsAndAnswers : AppCompatActivity() {
    val db = DataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answer_page)


        val question = findViewById<TextView>(R.id.question_id) // поле с текстом вопроса
        val answer = findViewById<TextView>(R.id.answer_id) // поле с текстом ответа/иструкции
        val listView = findViewById<ListView>(R.id.listView)    // поле списка вопросов
        val scrollView = findViewById<ScrollView>(R.id.scrollView)  // поле, которое можно скроллить

        // В стэк сохраняются ID вопросов из ветки, для того чтобы можно было вернуться назад
        val stack = ArrayList<Int>()

        db.open()

        stack.add(intent.getIntExtra("button", 0))  // записываем в стэк ID кнопки с предыдущего Activity
        var qu_table = db.list_of_questions(stack.last())   // список вопросов для этой кнопки (таблица)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question)    // помещаем вопросы в список на экране
        if (stack.last() == 1) {
            question.text = "Личный автомобиль"
        } else if (stack.last() == 2) {
            question.text = "Кикшеринг"
        }

        // Сдедующий код срабатывает при нажатии на вопрос
        listView.setOnItemClickListener{parent, view, position, id ->
            question.text = qu_table.question[position] // присваеваем в поле вопроса текст вопроса
            answer.text = qu_table.answer[position] // присваеваем в поле ответа текст ответа
            val is_test = qu_table.is_test[position]    // флаг (ведет ли вопрос к тесту или нет)

            // Если is_test = 1 переходи на Activity с тестом, иначе переходим к следующим подвопросам и ответам
            if (is_test != 0) {
                val intent = Intent(this, TestActivity::class.java)
                startActivity(intent)
            } else {
                stack.add(qu_table.ID[position])    // В стэк записываем ID вопроса
                qu_table = db.list_of_questions(stack.last())   // Подвопросы для этого вопроса
                listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question) // Помещаем вопросы в список на экране
                scrollView.scrollTo(0, 0)   // скролл наверхэкрана, чтобы вернуться в начало
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

                val qu = db.query_table(
                    "SELECT * FROM question\n" +
                        "WHERE id = ${stack.last()};"
                )

                question.text = qu.question[0]
                answer.text = qu.answer[0]

                listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question)
            }
        }

        //  Кнопка для перехода к странице контактов.
        val button: ImageView = findViewById(R.id.imageView)
        button.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}