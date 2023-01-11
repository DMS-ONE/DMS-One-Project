package com.yongjincompany.app.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import com.yongjincompany.app.R
import com.yongjincompany.app.databinding.ActivityMainBinding
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

        val random = (0..3).random()

        vm.fetchGitHubProfile(nameList[random])

        repeatOnStarted {
            vm.fetchGitHubProfileEvent.collect { event -> handleEvent(event) }
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
        binding.followerNum.text = gitHubProfileData.followers.toString()
        binding.followingNum.text = gitHubProfileData.following.toString()
        binding.description.text = gitHubProfileData.bio
        binding.ivProfile.loadFromUrl(gitHubProfileData.avatarUrl)

        if(gitHubProfileData.name == null) {
            binding.name.text = gitHubProfileData.login
        } else {
            binding.name.text = gitHubProfileData.name
        }
    }
}