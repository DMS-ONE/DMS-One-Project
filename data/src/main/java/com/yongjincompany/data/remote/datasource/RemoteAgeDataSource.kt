package com.yongjincompany.data.remote.datasource

import com.yongjincompany.data.remote.response.age.AgeResponse

interface RemoteAgeDataSource {
    suspend fun fetchAge(
        name: String,
        countryId: String,
    ): AgeResponse
}