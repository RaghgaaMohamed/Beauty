package com.example.beauty.product

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.beauty.ModelProduct
import com.example.beauty.R
import com.example.beauty.databinding.FragmentProductBinding
import com.route.islamigsun.base.BaseFragment


class ProductFragment : BaseFragment<FragmentProductBinding, ProductViewModel>(),Navigator {

    val args:ProductFragmentArgs by navArgs()
    lateinit var product:ModelProduct


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.vmProduct=viewModel
        viewModel.navigator=this
       product=args.modelProduct


        // transfer data from home to product fragment and put data on it.
       viewDataBinding.nameProductSelected.setText(product.name)
       viewDataBinding.sizeProductSelected.setText(product.size?.toString())
       viewDataBinding.priceProductSelected.setText(product.price.toString())
       viewDataBinding.selectedProductImage.setImageResource(product.images?:0)


        // go to cart fragment
       viewDataBinding.addToBag.setOnClickListener {
            findNavController().navigate(R.id.action_productFragment_to_cartFragment)
        }


        // calculate quantity of product
        viewDataBinding.add.setOnClickListener {
            var number=  viewDataBinding.quantity.text.toString().toInt()
            number++
            viewDataBinding.quantity.text=number.toString()

        }
        viewDataBinding.subtract.setOnClickListener {
            var number=  viewDataBinding.quantity.text.toString().toInt()
            number--
            if (number >= 0) {
                viewDataBinding.quantity.text=number.toString()
            }
        }


    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_product
    }

    override fun initializeViewModel(): ProductViewModel {
        return ViewModelProvider(this).get(ProductViewModel::class.java)
    }



      override fun gotoCartFragment() {
//       findNavController().navigate(R.id.action_productFragment_to_cartFragment)
    }





    override fun CalcQuantity() {
        var counter=1
        viewDataBinding.add.setOnClickListener {
            counter++
        }
        viewDataBinding.subtract.setOnClickListener {
            counter--
        }

         viewModel.quantity.set(counter.toString())
    }
}

