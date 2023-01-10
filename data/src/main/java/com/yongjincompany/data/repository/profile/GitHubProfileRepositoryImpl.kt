package com.yongjincompany.data.repository.profile

import com.yongjincompany.data.remote.datasource.RemoteGitHubProfileDataSource
import com.yongjincompany.data.remote.response.profile.GitHubProfileResponse
import com.yongjincompany.domain.entity.profile.GitHubProfileEntity
import com.yongjincompany.domain.repository.GitHubProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GitHubProfileRepositoryImpl @Inject constructor(
    private val remoteGitHubProfileDataSource: RemoteGitHubProfileDataSource
) : GitHubProfileRepository {
    override suspend fun fetchGitHubProfile(userName: String): Flow<GitHubProfileEntity> =
        flow { emit(remoteGitHubProfileDataSource.fetchGithubProfile(userName).toEntity()) }


    private fun GitHubProfileResponse.toEntity() =
        GitHubProfileEntity(
            avatarUrl = avatarUrl,
            bio = bio,
            followers = followers,
            following = following,
            login = login,
            name = name,
        )

}