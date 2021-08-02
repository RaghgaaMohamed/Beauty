package com.example.beauty.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.beauty.R
import com.example.beauty.adapter.CategoriesAdapter
import com.example.beauty.adapter.ProductsAdapter
import com.example.beauty.databinding.FragmentHomeBinding
import com.example.beauty.ModelProduct
import com.route.islamigsun.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>() {
    val tab_item= mutableListOf<String>()
    val imagesList= mutableListOf<Int>()
    val modelProduct= mutableListOf<ModelProduct>()
   lateinit var categoriesAdapter:CategoriesAdapter
  lateinit var productsAdapter: ProductsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.vm=viewModel
        setUpViews()
        // bottom navigation bar put there 3shan dont show lma aft7 fragment from home fragment
        viewDataBinding.navigation.selectedItemId=R.id.home_navigation

        // these for if we updated up to use other navigation
        viewDataBinding.navigation.setOnNavigationItemReselectedListener { item->
            if (item.itemId==R.id.home_navigation){
            }
        }

        productsAdapter.onProductClickL= object :ProductsAdapter.OnItemClickListener{
            override fun OnItemClick(position: Int, modelProduct: ModelProduct) {
                // go to Product Fragment with model product object
                val action=HomeFragmentDirections.actionHomeFragmentToProductFragment(modelProduct)
                     findNavController().navigate(action)

            }
        }


    }

    private fun postToList() {
        // add data to tab layout
        tab_item.add("Skin")
        tab_item.add("Hair")
        tab_item.add("Personal Care")
        tab_item.add("Other")
        //--------------------------------------------

        // add data to catregoires
        imagesList.add(R.drawable.flat1)
        imagesList.add(R.drawable.flat2)
        imagesList.add(R.drawable.flat3)
        imagesList.add(R.drawable.flat4)
        imagesList.add(R.drawable.flat5)
        imagesList.add(R.drawable.flat6)
        //-----------------------------------------------

        //add data to products
        modelProduct.add(ModelProduct(name = "Gentle Skin Cleanser",price = 12.29,size = 300, images = R.drawable.a2))
        modelProduct.add(ModelProduct(name = "Eye Cream",price = 10.12,size = 300,images =  R.drawable.b))
        modelProduct.add(ModelProduct(name= "Hand Cream",price = 12.29,size = 300 ,images =  R.drawable.c))
        modelProduct.add(ModelProduct(name = "Bath Salts",price = 11.29,size = 150 , images = R.drawable.d))


    }

    private fun setUpViews() {
        // insert data
        postToList()

        // Tab layout
        for (i in 0..tab_item.size-1) {
            val tab =viewDataBinding.tabLayout.newTab()
            tab.setText(tab_item.get(i))
            viewDataBinding.tabLayout.addTab(tab)
        }

 //       -------------------------------------------------

        // declere Categories Adapter
        categoriesAdapter= CategoriesAdapter(imagesList)
        viewDataBinding.rvCategories.adapter=categoriesAdapter

 //      --------------------------------------------------

        //declere Products Adapter
        productsAdapter= ProductsAdapter(modelProduct)
        viewDataBinding.productsRecyclerview.adapter=productsAdapter


    }



    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initializeViewModel(): HomeViewModel {
        return ViewModelProvider(this).get(HomeViewModel::class.java)
    }
}