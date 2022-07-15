package com.example.myapplication3

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TestActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_page)

        // Завершаем работу Activity при нажатии кнопки назад
        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            this.finish()
        }
    }
}