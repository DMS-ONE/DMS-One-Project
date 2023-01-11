package com.yongjincompany.domain.entity.profile


data class GitHubProfileEntity(
    val avatarUrl: String,
    val bio: String?,
    val followers: Int,
    val following: Int,
    val login: String,
    val name: String?,
)
