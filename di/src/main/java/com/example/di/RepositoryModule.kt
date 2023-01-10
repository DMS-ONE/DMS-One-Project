package com.example.di

import com.yongjincompany.data.repository.profile.GitHubProfileRepositoryImpl
import com.yongjincompany.domain.repository.GitHubProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providesRemoteGitHubProfileRepository(
        gitHubProfileRepositoryImpl: GitHubProfileRepositoryImpl
    ): GitHubProfileRepository
}
