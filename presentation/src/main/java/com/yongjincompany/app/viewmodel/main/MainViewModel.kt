package com.yongjincompany.app.viewmodel.main

import androidx.lifecycle.ViewModel
import com.yongjincompany.domain.usecase.profile.GitHubProfileUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val gitHubProfileUseCase: GitHubProfileUseCase
) : ViewModel() {

}