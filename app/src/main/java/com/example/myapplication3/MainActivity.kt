package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val db = DataBase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db.open()   // открываем базу данных для работы с ней
//        db.execute(DROP_TABLE_NODE)
//        db.execute(DROP_TABLE_QUESTION)
//        db.execute(CREATE_TABLE_QUESTION)
//        db.execute(CREATE_TABLE_NODE)
//        db.execute(FILL_QUESTION)
//        db.execute(FILL_NODE)
        val var_for_DTP_cat_button = findViewById<Button>(R.id.button_for_DTP_car)
        val var_for_DTP_kik_button = findViewById<Button>(R.id.button_for_DTP_kik)
        val var_for_PDD_cat_button = findViewById<Button>(R.id.button_for_PDD_car)
        val var_for_PDD_kik_button = findViewById<Button>(R.id.button_for_PDD_kik)
        val var_for_GIBDD = findViewById<Button>(R.id.button8)
        val var_for_FORM = findViewById<Button>(R.id.button7)
        val var_for_kikshering = findViewById<Button>(R.id.button_for_kikshering)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,button)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_dict ->
                    {
                        val intent = Intent(this, MainActivity3::class.java)
                        startActivity(intent)
                    }
                    R.id.action_convers ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_contacts ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })
            popupMenu.show()
        }

        var_for_DTP_cat_button.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            intent.putExtra("button", 1)
            // номер кнопки передается в следующий Activity (т. е. список вопросов),
            // чтобы можно было понять, какая кнопка была нажата, и вывести нужные вопросы из базы
            startActivity(intent)
        }

        var_for_DTP_kik_button.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            intent.putExtra("button", 2)
            startActivity(intent)
        }

        var_for_PDD_cat_button.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            intent.putExtra("button", 3)
            startActivity(intent)
        }

        var_for_PDD_kik_button.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            intent.putExtra("button", 4)
            startActivity(intent)
        }

        var_for_GIBDD.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            intent.putExtra("button", 5)
            startActivity(intent)
        }

        var_for_kikshering.setOnClickListener {
            val intent = Intent(this, SubquestionsAndAnswers::class.java)
            intent.putExtra("button", 6)
            startActivity(intent)
        }

        var button_for_Image: ImageView = findViewById(R.id.imageView)
        button_for_Image.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }

        var_for_FORM.setOnClickListener {
            val intent = Intent(this, ChoiceFormActivity::class.java)
            startActivity(intent)
        }
    }

    // закрываем базу при окончании работы activity
    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}