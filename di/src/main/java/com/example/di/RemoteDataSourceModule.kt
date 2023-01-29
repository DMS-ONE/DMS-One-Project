package com.example.di

import com.yongjincompany.data.remote.datasource.RemoteAgeDataSource
import com.yongjincompany.data.remote.datasource.RemoteAgeDataSourceImpl
import com.yongjincompany.data.remote.datasource.RemoteGitHubProfileDataSource
import com.yongjincompany.data.remote.datasource.RemoteGitHubProfileDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun provideRemoteGitHubProfileDataSource(
        remoteGitHubProfileDataSourceImpl: RemoteGitHubProfileDataSourceImpl
    ): RemoteGitHubProfileDataSource

    @Binds
    abstract fun provideRemoteAgeDataSource(
        ageDataSourceImpl: RemoteAgeDataSourceImpl,
    ): RemoteAgeDataSource
}
