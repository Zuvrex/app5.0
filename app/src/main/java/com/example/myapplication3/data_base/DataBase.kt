package com.example.myapplication3

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.myapplication3.data_base.DB_Helper


class QuTable(val ID: ArrayList<Int>, val question: ArrayList<String>, val answer: ArrayList<Int>)

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

    fun list_of_questions(id: Int): QuTable {
        val cursor = this.query(
        "SELECT q2.id, q2.question, q2.answer FROM question q1\n" +
            "    JOIN node n ON q1.id = n.question_id\n" +
            "    JOIN question q2 ON q2.id = n.sub_question_id\n" +
            "WHERE n.question_id = $id;"
        )

        val result = QuTable(ArrayList(), ArrayList(), ArrayList())
        while (cursor?.moveToNext()!!) {
            result.ID.add(cursor.getInt(0))
            result.question.add(cursor.getString(1))
            result.answer.add(cursor.getInt(2))
        }

        cursor.close()
        return result
    }

    fun close() {
        dbh.close()
    }
}