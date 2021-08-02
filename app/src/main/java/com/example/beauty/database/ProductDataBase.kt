package com.example.beauty.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Product::class],version = 1,exportSchema = false)
abstract class ProductDataBase :RoomDatabase(){
    abstract fun Dao():ProductDao

    companion object {
        @Volatile
        var database: ProductDataBase? = null
        private val DATABASE_NAME = "product-db"

        operator fun invoke(context: Context): ProductDataBase {
            return database ?: synchronized(Any()) {
                database ?: creatDatabase(context).also { database = it }
            }

        }

        private fun creatDatabase(context: Context): ProductDataBase {
return Room.databaseBuilder(context,ProductDataBase::class.java, DATABASE_NAME)
    .fallbackToDestructiveMigration()
    .build()
        }
    }

    }
