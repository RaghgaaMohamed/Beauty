package com.example.beauty

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelProduct (var id:Int?=null,
                         var name:String?=null,
                         var price:Double?=null,
                         var size:Int?=null,
                         var images:Int?=null):Parcelable