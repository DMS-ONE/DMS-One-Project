package com.yongjincompany.app.feature.main

import android.os.Bundle
import com.yongjincompany.app.R
import com.yongjincompany.app.databinding.ActivityMainBinding
import com.yongjincompany.app.util.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initView() {
        super.initView()


    }
}