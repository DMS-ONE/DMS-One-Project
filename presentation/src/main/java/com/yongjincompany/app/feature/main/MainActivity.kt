package com.yongjincompany.app.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.yongjincompany.app.R
import com.yongjincompany.app.databinding.ActivityMainBinding
import com.yongjincompany.app.feature.home.SelectActivity
import com.yongjincompany.app.util.BaseActivity
import com.yongjincompany.app.util.loadFromUrl
import com.yongjincompany.app.util.repeatOnStarted
import com.yongjincompany.app.viewmodel.main.FetchGitHubProfileViewModel
import com.yongjincompany.app.viewmodel.main.FetchGitHubProfileViewModel.*
import com.yongjincompany.domain.entity.profile.GitHubProfileEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    private val vm: FetchGitHubProfileViewModel by viewModels()
    private val nameList = listOf("leesin0222", "Tmdhoon2", "chlgkdms")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val random = (0..2).random()

        vm.fetchGitHubProfile(nameList[random])

        repeatOnStarted {
            vm.fetchGitHubProfileEvent.collect { event -> handleEvent(event) }
        }
    }

    override fun initView() {
        super.initView()

        binding.btnNext.setOnClickListener {
            val intent = Intent(baseContext, SelectActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handleEvent(event: FetchGitHubProfileEvent) {
        when (event) {
            is FetchGitHubProfileEvent.FetchGitHubProfile -> setProfileValue(event.gitHubProfileEntity)
            is FetchGitHubProfileEvent.ErrorMessage -> {
                showShortToast(event.errorMessage)
            }
        }
    }

    private fun setProfileValue(gitHubProfileData: GitHubProfileEntity) {
        gitHubProfileData.let {
            binding.tvFollowerNum.text = it.followers.toString()
            binding.tvFollowingNum.text = it.following.toString()
            binding.tvDescription.text = it.bio ?: "난 우주최강 개발자"
            binding.ivProfile.loadFromUrl(it.avatarUrl)
            binding.tvName.text = it.name ?: it.login
        }
    }
}