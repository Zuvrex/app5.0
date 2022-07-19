package com.example.myapplication3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        // Creating method for initiating contacts window.
        var button: ImageView = findViewById(R.id.imageView)
        button.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }

        val home = findViewById<Button>(R.id.home)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        // Creating web link activity.
        var textRuleLink: TextView = findViewById(R.id.link_id)
        textRuleLink.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://ГИБДД.рф/"))
            startActivity(i)
                //http://www.consultant.ru/document/cons_doc_LAW_280037/
        }
    }

}