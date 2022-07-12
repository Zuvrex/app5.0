package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication3.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var adapter: ItemAdapter
    private lateinit var b: ActivityMain3Binding
    private val foodItemsList: MutableList<ListItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(b.root)

        populateList()

        setUpAdapter()
    }
    private fun setUpAdapter() {

        adapter = ItemAdapter(this,foodItemsList)

        b.foodItemsRV.adapter = adapter
        b.foodItemsRV.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
        val names = arrayOf("Могу ли я узнать показания скорости на радаре у инспектора?",
            "Можно ли заплатить штраф меньше?",
            "Какие есть ограничения по скорости?",
            "Где можно парковаться?",
            "Можно ли парковаться на тротуаре?",
            "Можно ли парковаться на пешеходном переходе?",
            "Насколько сильно можно затонировать стекла?",
            "Можно ли ездить зимой на летней резине?",
            "Вопрос 9",
            "Вопрос 10",
            "Вопрос 11",
            "Вопрос 12")
        for (i in 0..names.size - 1){
            val name = names[i]
            val listItem = ListItem(name = name)
            foodItemsList.add(listItem)
        }
    }
}