package com.yongjincompany.domain.usecase.profile

import com.yongjincompany.domain.entity.profile.GitHubProfileEntity
import com.yongjincompany.domain.repository.GitHubProfileRepository
import com.yongjincompany.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GitHubProfileUseCase @Inject constructor(
    private val gitHubProfileRepository: GitHubProfileRepository
) : UseCase<String, Flow<GitHubProfileEntity>>() {
    override suspend fun execute(data: String): Flow<GitHubProfileEntity> =
        gitHubProfileRepository.fetchGitHubProfile(data)
}