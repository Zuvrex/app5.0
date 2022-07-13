package com.example.myapplication3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity3652: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page3652)

        // Creating method for initiating contacts window.
        val button: ImageView = findViewById(R.id.imageView)
        button.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }

        // Creating web link activity.
        val textRuleLink: TextView = findViewById(R.id.link_3562)
        textRuleLink.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.consultant.ru/document/cons_doc_LAW_2709/59ded54942baa2143676e12b31244b0cb7ada00d/#:~:text=%D0%9D%D0%B0%20%D0%BB%D0%B5%D0%B2%D0%BE%D0%B9%20%D1%81%D1%82%D0%BE%D1%80%D0%BE%D0%BD%D0%B5%20%D0%B4%D0%BE%D1%80%D0%BE%D0%B3%D0%B8%20%D0%BE%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0,%D0%BB%D0%B5%D0%B2%D0%BE%D0%B9%20%D1%81%D1%82%D0%BE%D1%80%D0%BE%D0%BD%D0%B5%20%D0%B4%D0%BE%D1%80%D0%BE%D0%B3%20%D1%81%20%D0%BE%D0%B4%D0%BD%D0%BE%D1%81%D1%82%D0%BE%D1%80%D0%BE%D0%BD%D0%BD%D0%B8%D0%BC/"))
            startActivity(i)
            //http://www.consultant.ru/document/cons_doc_LAW_280037/
        }
    }
}