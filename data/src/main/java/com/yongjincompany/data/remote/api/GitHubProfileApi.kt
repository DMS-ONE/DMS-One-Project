package com.yongjincompany.data.remote.api

import com.yongjincompany.data.remote.response.profile.GitHubProfileResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubProfileApi {
    @GET("users/{userName}")
    suspend fun fetchGithubProfile(
        @Path("userName") userName: String
    ): GitHubProfileResponse
}