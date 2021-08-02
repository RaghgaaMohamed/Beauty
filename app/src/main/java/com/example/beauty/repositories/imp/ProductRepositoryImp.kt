package com.example.beautyproducts.data.repositories.imp

import androidx.lifecycle.LiveData
import com.example.beauty.database.Product
import com.example.beautyproducts.data.repositories.ProductRepository
import com.example.beautyproducts.data.repositories.datasource.OfflineDataSource

class ProductRepositoryImp(val offlineDataSource: OfflineDataSource): ProductRepository {
    override suspend fun getProducts(): LiveData<List<Product>> {
       return offlineDataSource.getProducts()
    }

    override suspend fun addProduct(product: Product) {
        offlineDataSource.addProduct(product)
    }
}