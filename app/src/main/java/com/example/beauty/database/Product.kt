package com.example.beauty.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Product (
    @ColumnInfo
    var quantity:Int,
    @ColumnInfo
    var name:String,
    @ColumnInfo
    var price:Double,
    @ColumnInfo
    var size:Int){

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}