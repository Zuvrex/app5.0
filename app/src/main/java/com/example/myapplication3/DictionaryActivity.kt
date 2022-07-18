package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.databinding.ActivityDictionaryBinding

class DictionaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDictionaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDictionaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
    fun home_activity(view: View){
        val Home_acitivity= Intent(this,MainActivity::class.java)
        startActivity(Home_acitivity)
    }
}