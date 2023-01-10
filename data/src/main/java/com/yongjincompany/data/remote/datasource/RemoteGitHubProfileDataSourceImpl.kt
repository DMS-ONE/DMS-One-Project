package com.yongjincompany.data.remote.datasource

import com.yongjincompany.data.remote.api.GitHubProfileApi
import com.yongjincompany.data.remote.response.profile.GitHubProfileResponse
import com.yongjincompany.data.util.HttpHandler
import javax.inject.Inject

class RemoteGitHubProfileDataSourceImpl @Inject constructor(
    private val gitHubProfileApi: GitHubProfileApi
) : RemoteGitHubProfileDataSource {
    override suspend fun fetchGithubProfile(userName: String) =
        HttpHandler<GitHubProfileResponse>()
            .httpRequest { gitHubProfileApi.fetchGithubProfile(userName) }
            .sendRequest()
}