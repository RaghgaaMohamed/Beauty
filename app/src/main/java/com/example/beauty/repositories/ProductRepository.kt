package com.example.beautyproducts.data.repositories


import androidx.lifecycle.LiveData
import com.example.beauty.database.Product

interface ProductRepository{
suspend fun getProducts():LiveData<List<Product>>
suspend fun addProduct(product: Product)
}