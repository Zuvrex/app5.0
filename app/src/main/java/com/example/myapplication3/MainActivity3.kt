package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication3.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var adapter: FoodItemAdapter
    private lateinit var b: ActivityMain3Binding
    private val foodItemsList: MutableList<FoodItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(b.root)

        populateList()

        setUpAdapter()
    }
    private fun setUpAdapter() {

        adapter = FoodItemAdapter(this,foodItemsList)

        b.foodItemsRV.adapter = adapter
        b.foodItemsRV.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
        for (i in 1..15){
            val name = "Food Item $i"
            val price = (100 * i).toFloat()

            val foodItem = FoodItem(name = name, price = price)

            foodItemsList.add(foodItem)
        }
    }
}