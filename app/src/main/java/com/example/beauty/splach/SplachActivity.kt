package com.example.beauty.splach

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import com.example.beauty.main.MainActivity
import com.example.beauty.R
import com.example.beauty.databinding.ActivitySplachBinding
import com.route.islamigsun.base.BaseActivity

class SplachActivity : BaseActivity<ActivitySplachBinding,SplachViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // start animation
        val zoom = AnimationUtils.loadAnimation(this , R.anim.zoom)
        viewDataBinding.circle.startAnimation(zoom)


        //go to main activity
        Handler(Looper.getMainLooper()).postDelayed({
            gotoMainActivity()
        },2000)


    }

    private fun gotoMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splach
    }

    override fun initializeViewModel(): SplachViewModel {
      return ViewModelProvider(this).get(SplachViewModel::class.java)
    }
}