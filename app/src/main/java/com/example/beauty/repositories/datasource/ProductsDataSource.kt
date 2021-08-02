package com.example.beautyproducts.data.repositories.datasource

import androidx.lifecycle.LiveData
import com.example.beauty.ModelProduct
import com.example.beauty.database.Product


interface OfflineDataSource{
    suspend fun getProducts(): LiveData<List<Product>>
    suspend fun addProduct(product:Product)
}