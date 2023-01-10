package com.yongjincompany.domain.repository

import com.yongjincompany.domain.entity.profile.GitHubProfileEntity
import kotlinx.coroutines.flow.Flow

interface GitHubProfileRepository {
    suspend fun fetchGitHubProfile(userName: String): Flow<GitHubProfileEntity>
}