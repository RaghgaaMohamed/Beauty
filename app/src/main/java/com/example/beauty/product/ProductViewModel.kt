package com.example.beauty.product

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.beauty.cart.CartFragment
import com.example.beauty.database.Product
import com.example.beauty.database.ProductDataBase
import com.example.beautyproducts.data.repositories.ProductRepository
import com.example.beautyproducts.data.repositories.datasource.OfflineDataSource
import com.example.beautyproducts.data.repositories.imp.OfflineDataSourcesImp
import com.example.beautyproducts.data.repositories.imp.ProductRepositoryImp
import com.route.chatappc34.base.BaseViewModel
import kotlinx.coroutines.launch

class ProductViewModel :BaseViewModel<Navigator>() {
/*
    val dataBase = ProductDataBase(//need context ?)
    var offlineDataSource: OfflineDataSource = OfflineDataSourcesImp(dataBase)
    val repository: ProductRepository = ProductRepositoryImp(offlineDataSource)
*/

    val productLiveData=MutableLiveData<Product>()
    val Allproducts=MutableLiveData<LiveData<List<Product>>>()

    var quantity=ObservableField<String>()
    var name= ObservableField<String>()
    var price=ObservableField<Double>()
    var size =ObservableField<Int>()


    fun ClickatAddToBag(){

    // insert product in data base
        viewModelScope.launch {

  /*      val product=repository.addProduct(Product(quantity.toString().toInt(),name.toString(),price.toString().toDouble(),size.toString().toInt())) as Product

            productLiveData.value=product
*/
}
    }

    fun Calcquantity() {
    navigator?.CalcQuantity()
    }
}