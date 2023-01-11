package com.yongjincompany.data.remote.response.profile

import com.google.gson.annotations.SerializedName

data class GitHubProfileResponse(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("bio") val bio: String?,
    @SerializedName("followers") val followers: Int,
    @SerializedName("following") val following: Int,
    @SerializedName("login") val login: String,
    @SerializedName("name") val name: String?,
)