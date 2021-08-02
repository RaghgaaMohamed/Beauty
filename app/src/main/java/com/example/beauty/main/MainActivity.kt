package com.example.beauty.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.beauty.R
import com.example.beauty.databinding.ActivityMainBinding
import com.example.beauty.home.HomeFragment
import com.route.islamigsun.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// this for mark home fragment as show to user when open app



    }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initializeViewModel(): MainViewModel {
         return ViewModelProvider(this).get(MainViewModel::class.java)
    }
}