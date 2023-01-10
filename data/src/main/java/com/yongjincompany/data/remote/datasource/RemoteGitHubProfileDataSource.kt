package com.yongjincompany.data.remote.datasource

import com.yongjincompany.data.remote.response.profile.GitHubProfileResponse

interface RemoteGitHubProfileDataSource {
    suspend fun fetchGithubProfile(userName: String): GitHubProfileResponse
}