package com.example.di

import com.yongjincompany.data.remote.api.AgifyioApi
import com.yongjincompany.data.remote.api.GitHubProfileApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    private const val BASE_URL = "https://api.github.com/"

    private const val AGIFYIO_BASE_URL = "https://api.agify.io"

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Github

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Agifyio

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpclient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @Github
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Agifyio
    @Provides
    fun provideAgeRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(AGIFYIO_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    fun provideGitHubProfileApi(
        @Github retrofit: Retrofit,
    ): GitHubProfileApi =
        retrofit.create(GitHubProfileApi::class.java)

    @Provides
    fun provideAgifyioApi(
        @Agifyio retrofit: Retrofit,
    ): AgifyioApi =
        retrofit.create(AgifyioApi::class.java)
}
