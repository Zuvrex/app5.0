package com.example.myapplication3

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.myapplication3.data_base.DB_Helper


// Таблица с вопросами (в нее сохраняются запросы из БД)
// Имеет поля id, текст вопроса, текст ответа/инструкции, флаг (ведет ли вопрос к тесту)
class QuTable(
    val ID: ArrayList<Int>,
    val question: ArrayList<String>,
    val answer: ArrayList<String>,
    val is_test: ArrayList<Int>
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

    fun query_table(sql: String): QuTable {
        val cursor = this.query(sql)

        val result = QuTable(ArrayList(), ArrayList(), ArrayList(), ArrayList())
        while (cursor?.moveToNext()!!) {
            result.ID.add(cursor.getInt(0))
            result.question.add(cursor.getString(1))
            result.answer.add(cursor.getString(2))
            result.is_test.add(cursor.getInt(3))
        }

        cursor.close()
        return result
    }

    // Функция выводящая таблицу с вопросами (см. выше).
    // Она выводит вопросы по id кнопки или подвопросы по id вопроса
    fun list_of_questions(id: Int): QuTable {
        return this.query_table(
            "SELECT q2.id, q2.question, q2.answer, q2.is_test FROM question q1\n" +
                "    JOIN node n ON q1.id = n.question_id\n" +
                "    JOIN question q2 ON q2.id = n.sub_question_id\n" +
                "WHERE n.question_id = $id;"
        )
    }

    fun close() {
        dbh.close()
    }
}