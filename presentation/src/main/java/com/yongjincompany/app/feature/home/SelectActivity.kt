package com.yongjincompany.app.feature.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.yongjincompany.app.databinding.ActivitySelectBinding
import com.yongjincompany.app.util.BaseActivity
import com.yongjincompany.app.R
import com.yongjincompany.app.feature.dledledle.SeunghoonActivity
import com.yongjincompany.app.util.loadFromUrl
import com.yongjincompany.app.util.repeatOnStarted
import com.yongjincompany.app.viewmodel.main.FetchGitHubProfileViewModel
import com.yongjincompany.domain.entity.profile.GitHubProfileEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectActivity : BaseActivity<ActivitySelectBinding>(
    R.layout.activity_select
){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initView() {
        super.initView()

        binding.cvJungseunghoonCard.setOnClickListener {
            //TODO : 승훈 카드 눌렀을 때 넘어가는 동작 만들어주기
            startActivity(Intent(
                this,
                SeunghoonActivity::class.java,
            ))
        }

        binding.cvYongjinCard.setOnClickListener {
            //TODO : 용진 카드 눌렀을 때 넘어가는 동작 만들어주기
        }

        binding.cvChoihaeunCard.setOnClickListener {
            //TODO : 하은 카드 눌렀을 때 넘어가는 동작 만들어주기
        }
    }
}