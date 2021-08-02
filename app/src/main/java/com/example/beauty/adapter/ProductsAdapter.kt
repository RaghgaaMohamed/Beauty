package com.example.beauty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.beauty.R
import com.example.beauty.databinding.ProductItemBinding
import com.example.beauty.ModelProduct

class ProductsAdapter(var productList: List<ModelProduct>):RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val productItem =LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ViewHolder(productItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productItem= productList.get(position)
        holder.name.setText(productItem.name)
        holder.price.setText(productItem.price.toString())
        holder.size.setText(productItem.size.toString())
        holder.image.setImageResource(productItem.images.toString().toInt())

        if (onProductClickL!=null){
            holder.itemView.setOnClickListener {
                onProductClickL?.OnItemClick(position,productItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

  var onProductClickL:OnItemClickListener?=null
    interface OnItemClickListener{
        fun OnItemClick(position:Int,modelProduct: ModelProduct)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: TextView =itemView.findViewById(R.id.name_product)
        val price: TextView =itemView.findViewById(R.id.price_product)
        val size : TextView =itemView.findViewById(R.id.size_product)
        val image: ImageView =itemView.findViewById(R.id.image_product)

    }
}