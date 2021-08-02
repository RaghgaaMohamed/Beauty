package com.example.beauty.cart

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContentProviderCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.beauty.R
import com.example.beauty.adapter.CartAdapter
import com.example.beauty.database.ProductDataBase
import com.example.beauty.databinding.FragmentCartBinding
import com.example.beauty.product.ProductViewModel
import com.example.beautyproducts.data.repositories.ProductRepository
import com.example.beautyproducts.data.repositories.datasource.OfflineDataSource
import com.example.beautyproducts.data.repositories.imp.OfflineDataSourcesImp
import com.example.beautyproducts.data.repositories.imp.ProductRepositoryImp
import com.route.islamigsun.base.BaseFragment


class CartFragment : BaseFragment<FragmentCartBinding,ProductViewModel>() {
  lateinit var cartAdapter: CartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()

        // go to home fragment
        viewDataBinding.contiueBtn.setOnClickListener {
            findNavController().navigate(R.id.action_cartFragment_to_homeFragment)
        }



   /*  viewModel.ClickatAddToBag()
        observableData()    // wants to get all products in database and put it in recycler view by change data in adapter .
    */

    }



    private fun setUpViews() {
        cartAdapter= CartAdapter(listOf())
        viewDataBinding.cartRecyclerview.adapter=cartAdapter
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_cart
    }

    override fun initializeViewModel(): ProductViewModel {
        return ViewModelProvider(this).get(ProductViewModel::class.java)
    }
}