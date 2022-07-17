package com.example.myapplication3.data_base

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myapplication3.*

class DB_Helper(context: Context): SQLiteOpenHelper(context, "Tree.db", null, 15) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_QUESTION)
        db?.execSQL(CREATE_TABLE_NODE)
        db?.execSQL(FILL_QUESTION)
        db?.execSQL(FILL_NODE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_NODE)
        db?.execSQL(DROP_TABLE_QUESTION)
        onCreate(db)
    }
}