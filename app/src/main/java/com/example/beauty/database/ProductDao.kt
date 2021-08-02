package com.example.beauty.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //IGNORE
    fun addProduct(product: Product)

    @Query("select * from Product")
    fun getAllProduct():LiveData<List<Product>>  //LiveData<List<Product>>


}