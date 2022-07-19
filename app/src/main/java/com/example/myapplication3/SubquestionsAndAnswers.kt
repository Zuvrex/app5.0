package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.test.TestQuestion1


class SubquestionsAndAnswers : AppCompatActivity() {
    private val db = DataBase(this)
    private lateinit var qu_table: QuTable

    private lateinit var question: TextView
    private lateinit var answer: TextView
    private lateinit var listView: ListView
    private lateinit var scrollView: ScrollView

    // В стэк сохраняются ID вопросов из ветки, для того чтобы можно было вернуться назад
    private val stack = ArrayList<Int>()

    private fun back_fun() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answer_page)

        question = findViewById<TextView>(R.id.question_id) // поле с текстом вопроса
        answer = findViewById<TextView>(R.id.answer_id) // поле с текстом ответа/иструкции
        listView = findViewById<ListView>(R.id.listView)    // поле списка вопросов
        scrollView = findViewById<ScrollView>(R.id.scrollView)  // поле, которое можно скроллить

        db.open()

        stack.add(intent.getIntExtra("button", 0))  // записываем в стэк ID кнопки с предыдущего Activity
        qu_table = db.list_of_questions(stack.last())   // список вопросов для этой кнопки (таблица)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question)    // помещаем вопросы в список на экране
        if (stack.last() == 1) {
            question.text = "ДТП на машине"
        } else if (stack.last() == 2) {
            question.text = "ДТП на самокате"
        }
        else if (stack.last() == 3) {
            question.text = "ПДД для машины"
        }
        else if (stack.last() == 4) {
            question.text = "ПДД для самоката"
        }
        else if (stack.last() == 5) {
            question.text = "Общение с инспектором"
        } else if (stack.last() == 132 || stack.last() == 133 || stack.last() == 211 || stack.last() == 212) {
            question.text = intent.getStringExtra("text")
        }

        // Сдедующий код срабатывает при нажатии на вопрос
        listView.setOnItemClickListener{parent, view, position, id ->
            val is_test = qu_table.is_test[position]    // флаг (ведет ли вопрос к тесту или нет)
            // Если is_test = 1 переходи на Activity с тестом, иначе переходим к следующим подвопросам и ответам
            if (is_test != 0) {
                val intent = Intent(this, TestQuestion1::class.java)
                intent.putExtra("last", stack.last())
                startActivity(intent)
            } else {
                question.text = qu_table.question[position] // присваеваем в поле вопроса текст вопроса
                answer.text = qu_table.answer[position] // присваеваем в поле ответа текст ответа

                stack.add(qu_table.ID[position])    // В стэк записываем ID вопроса
                qu_table = db.list_of_questions(stack.last())   // Подвопросы для этого вопроса
                listView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, qu_table.question) // Помещаем вопросы в список на экране
                scrollView.scrollTo(0, 0)   // скролл наверхэкрана, чтобы вернуться в начало
            }
        }

        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        // кнопка для возвращения назад
        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            back_fun()
        }

        //  Кнопка для перехода к странице контактов.
        val button: ImageView = findViewById(R.id.imageView)
        button.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        back_fun()
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}