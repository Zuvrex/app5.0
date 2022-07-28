package com.example.myapplication3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.databinding.DictionaryItemLayoutBinding

class DictItemAdapter(private val context: Context, private val dictItemList:MutableList<DictListItem>)
    : RecyclerView.Adapter<DictItemAdapter.DictItemViewHolder>() {
    var contextR = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictItemViewHolder {
        val binding = DictionaryItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return DictItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DictItemViewHolder, position: Int) {
        val foodItem = dictItemList[position]
        holder.bind(foodItem, contextR)
    }

    override fun getItemCount(): Int {
        return dictItemList.size
    }


    class DictItemViewHolder(dictItemLayoutBinding: DictionaryItemLayoutBinding)
        : RecyclerView.ViewHolder(dictItemLayoutBinding.root){

        private val binding = dictItemLayoutBinding

        fun bind(listItem: DictListItem, context: Context){
            binding.dictItemNameTV.text = listItem.name
        }

    }
}