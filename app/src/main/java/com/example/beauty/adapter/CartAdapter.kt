package com.example.beauty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beauty.R
import com.example.beauty.database.Product

class CartAdapter(var soldList:List<Product>):RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cart_item , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
          val soldItem=soldList.get(position)
        holder.name.setText(soldItem.name)
        holder.price.setText(soldItem.price.toString())
        holder.size.setText(soldItem.size.toString())

    }

    override fun getItemCount(): Int {
        return soldList.size
    }

    fun changeData(product: List<Product>){
        this.soldList=product
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView =itemView.findViewById(R.id.name_sold)
        val price: TextView =itemView.findViewById(R.id.price_sold)
        val size : TextView =itemView.findViewById(R.id.name_sold)
        val quantity:TextView=itemView.findViewById(R.id.quantity_sold)
        val image: ImageView =itemView.findViewById(R.id.image_sold)
    }

}