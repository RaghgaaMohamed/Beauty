package com.example.beauty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.beauty.R

class CategoriesAdapter(var imagesCatList: List<Int>):RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val image =imagesCatList.get(position)
        holder.itemPicture.setImageResource(image)

    }

    override fun getItemCount(): Int {
      return imagesCatList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val itemPicture : ImageView = itemView.findViewById(R.id.image_caterories)
    }
}