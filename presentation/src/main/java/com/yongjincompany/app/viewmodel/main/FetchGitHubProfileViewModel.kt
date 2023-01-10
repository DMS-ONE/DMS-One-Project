package com.yongjincompany.app.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincompany.app.util.MutableEventFlow
import com.yongjincompany.app.util.asEventFlow
import com.yongjincompany.domain.entity.profile.GitHubProfileEntity
import com.yongjincompany.domain.exception.BadRequestException
import com.yongjincompany.domain.exception.ForbiddenException
import com.yongjincompany.domain.exception.UnauthorizedException
import com.yongjincompany.domain.usecase.profile.GitHubProfileUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FetchGitHubProfileViewModel @Inject constructor(
    private val gitHubProfileUseCase: GitHubProfileUseCase
) : ViewModel() {

    private val _fetchGitHubProfileEvent = MutableEventFlow<FetchGitHubProfileEvent>()
    val fetchGitHubProfileEvent = _fetchGitHubProfileEvent.asEventFlow()

    fun fetchGitHubProfile(userName: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                gitHubProfileUseCase.execute(userName).collect {
                    FetchGitHubProfileEvent.FetchGitHubProfile(it)
                }
            }.onFailure {
                when (it) {
                    is ForbiddenException -> {
                        FetchGitHubProfileEvent.ErrorMessage("권한 때문에 요청이 거절되었습니다")
                    }
                    is UnauthorizedException -> {
                        FetchGitHubProfileEvent.ErrorMessage("인증이 필요합니다")
                    }
                }
            }
        }
    }

    sealed class FetchGitHubProfileEvent() {

        data class FetchGitHubProfile(val gitHubProfileEntity: GitHubProfileEntity) : FetchGitHubProfileEvent()

        data class ErrorMessage(val errorMessage: String) : FetchGitHubProfileEvent()
    }
}