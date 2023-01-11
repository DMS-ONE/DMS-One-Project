package com.yongjincompany.app.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincompany.app.util.MutableEventFlow
import com.yongjincompany.app.util.asEventFlow
import com.yongjincompany.app.viewmodel.main.FetchGitHubProfileViewModel.FetchGitHubProfileEvent.*
import com.yongjincompany.domain.entity.profile.GitHubProfileEntity
import com.yongjincompany.domain.exception.ForbiddenException
import com.yongjincompany.domain.exception.UnauthorizedException
import com.yongjincompany.domain.usecase.profile.GitHubProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FetchGitHubProfileViewModel @Inject constructor(
    private val gitHubProfileUseCase: GitHubProfileUseCase
) : ViewModel() {

    private val _fetchGitHubProfileEvent = MutableEventFlow<FetchGitHubProfileEvent>()
    val fetchGitHubProfileEvent = _fetchGitHubProfileEvent.asEventFlow()

    fun fetchGitHubProfile(userName: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                gitHubProfileUseCase.execute(userName).collect {
                    event(FetchGitHubProfile(it.toData()))
                }
            }.onFailure {
                when (it) {
                    is ForbiddenException -> {
                        event(ErrorMessage("권한 때문에 요청이 거절되었습니다"))
                    }

                    is UnauthorizedException -> {
                        event(ErrorMessage("인증이 필요합니다"))
                    }

                    else -> {
                        event(ErrorMessage("알 수 없는 에러"))
                    }
                }
            }
        }
    }

    private fun event(event: FetchGitHubProfileEvent) {
        viewModelScope.launch {
            _fetchGitHubProfileEvent.emit(event)
        }
    }

    sealed class FetchGitHubProfileEvent {

        data class FetchGitHubProfile(val gitHubProfileEntity: GitHubProfileEntity) : FetchGitHubProfileEvent()

        data class ErrorMessage(val errorMessage: String) : FetchGitHubProfileEvent()
    }

    private fun GitHubProfileEntity.toData() =
        GitHubProfileEntity(
            avatarUrl = avatarUrl,
            bio = bio,
            followers = followers,
            following = following,
            login = login,
            name = name,
        )
}