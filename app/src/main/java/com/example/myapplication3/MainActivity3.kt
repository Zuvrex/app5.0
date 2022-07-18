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
        val names = arrayOf("Кикшеринг - это система предоставления в " +
                "краткосрочную аренду электросамокатов и самокатов с помощью приложения.",
            "ГИБДД – Государственная инспекция безопасности дорожного движения",
            "Министерство внутренних дел (МВД) — орган исполнительной власти, государственное учреждение," +
                    " в большинстве государств мира, как правило, выполняющий " +
                    "административно-распорядительные функции в сфере обеспечения общественной " +
                    "безопасности, охраны правопорядка, борьбы с преступностью.",
            "Тауметр – это прибор, предназначенный для измерения количества света, которое пропускает стекло.",
            "Автомагистра́ль — дорога для скоростного движения автомобилей, не имеющая одноуровневых " +
                    "пересечений с другими дорогами, " +
                    "железнодорожными или трамвайными путями, пешеходными или велосипедными дорожками.",
            "Иск — требование, подаваемое в суд, судебное действие истца, обратившегося к помощи суда, " +
                    "чтобы обязать ответчика признать его право или исполнить то, что он должен.",
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