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
        val names = arrayOf("Бустер — это сиденье с небольшими подлокотниками без спинки. " +
                "Оно приподнимает ребенка, чтобы штатный ремень безопасности проходил в области груди, а не шеи. ",
            "ГИБДД – Государственная инспекция безопасности дорожного движения",
            "Кикшеринг - это система предоставления в " +
                "краткосрочную аренду электросамокатов и самокатов с помощью приложения.",
            "Обязательное страхование автогражданской ответственности (ОСАГО) – это вид страхования, " +
                    "не связанный с защитой страхователя или его имущества. " +
                    "Страхуется его ответственность за причинение ущерба третьим лицам при дорожно-транспортных происшествиях.",
            "Тауметр – это прибор, предназначенный для измерения количества света, которое пропускает стекло.")
        for (i in 0..names.size - 1){
            val name = names[i]
            val listItem = ListItem(name = name)
            foodItemsList.add(listItem)
        }
    }
}