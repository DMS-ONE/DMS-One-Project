package com.yongjincompany.data.remote.api

import com.yongjincompany.data.remote.response.age.AgeResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AgifyioApi {
    @GET("/")
    suspend fun fetchAge(
        @Query("name") name: String,
    ): AgeResponse
}