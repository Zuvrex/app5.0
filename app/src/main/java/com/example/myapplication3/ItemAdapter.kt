package com.example.myapplication3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.databinding.ItemLayoutBinding

class ItemAdapter(private val context: Context, private val foodItemList:MutableList<ListItem>)
    : RecyclerView.Adapter<ItemAdapter.FoodItemViewHolder>() {
    var contextR = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return FoodItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        val foodItem = foodItemList[position]
        holder.bind(foodItem, contextR)
    }

    override fun getItemCount(): Int {
        return foodItemList.size
    }


    class FoodItemViewHolder(foodItemLayoutBinding: ItemLayoutBinding)
        : RecyclerView.ViewHolder(foodItemLayoutBinding.root){

        private val binding = foodItemLayoutBinding

        fun bind(listItem: ListItem, context: Context){
            binding.foodItemNameTV.text = listItem.name
            itemView.setOnClickListener() {
                val i = Intent(context, ContentActivity::class.java).apply {
                }
                context.startActivity(i)
            }
        }

    }
}