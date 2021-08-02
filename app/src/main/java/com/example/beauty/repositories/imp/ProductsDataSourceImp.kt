package com.example.beautyproducts.data.repositories.imp

import androidx.lifecycle.LiveData
import com.example.beauty.database.Product
import com.example.beauty.database.ProductDataBase
import com.example.beautyproducts.data.repositories.datasource.OfflineDataSource

class OfflineDataSourcesImp(val database:ProductDataBase):OfflineDataSource{
    override suspend fun getProducts(): LiveData<List<Product>> {

        val products =database.Dao()
            .getAllProduct()
        return products
    }

    override suspend fun addProduct(product: Product) {
        var product=database.Dao()
                .addProduct(product)
    }


}