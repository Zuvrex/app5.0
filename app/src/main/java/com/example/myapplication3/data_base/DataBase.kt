package com.example.myapplication3

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.myapplication3.data_base.DB_Helper


// Таблица с вопросами (в нее сохраняются запросы из БД)
// Имеет поля id, текст вопроса, краткий ответ, развернутый ответ или инструкция, ссылка, текст ссылки
class QuTable(
    val ID: ArrayList<Int>,
    val question: ArrayList<String>,
    val short_ans: ArrayList<String>,
    val main_text: ArrayList<String>,
    val link: ArrayList<String>,
    val link_text: ArrayList<String>
)

class DataBase(val context: Context) {
    val dbh = DB_Helper(context)
    var db: SQLiteDatabase? = null

    fun open() {
        db = dbh.writableDatabase
    }

    fun execute(sql: String) {
        db?.execSQL(sql)
    }

    fun query(sql: String): Cursor? {
        return db?.rawQuery(sql, null)
    }

    // Функция выводящая таблицу с вопросами (см. выше).
    // Она выводит вопросы по id кнопки или подвопросы по id вопроса
    fun list_of_questions(id: Int): QuTable {
        val cursor = this.query(
        "SELECT q2.id, q2.question, q2.short_ans, q2.main_text, q2.link, q2.link_text FROM question q1\n" +
            "    JOIN node n ON q1.id = n.question_id\n" +
            "    JOIN question q2 ON q2.id = n.sub_question_id\n" +
            "WHERE n.question_id = $id;"
        )

        val result = QuTable(ArrayList(), ArrayList(), ArrayList(), ArrayList(), ArrayList(), ArrayList())
        while (cursor?.moveToNext()!!) {
            result.ID.add(cursor.getInt(0))
            result.question.add(cursor.getString(1))
            result.short_ans.add(cursor.getString(2))
            result.main_text.add(cursor.getString(3))
            result.link.add(cursor.getString(4))
            result.link_text.add(cursor.getString(5))
        }

        cursor.close()
        return result
    }

    fun close() {
        dbh.close()
    }
}