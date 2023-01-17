package com.yongjincompany.data.remote.datasource

import com.yongjincompany.data.remote.api.AgifyioApi
import com.yongjincompany.data.remote.response.age.AgeResponse
import com.yongjincompany.data.util.HttpHandler
import javax.inject.Inject

class RemoteAgeDataSourceImpl @Inject constructor(
    private val agifyioApi: AgifyioApi,
) : RemoteAgeDataSource {
    override suspend fun fetchAge(
        name: String,
        countryId: String,
    ): AgeResponse =
        HttpHandler<AgeResponse>()
            .httpRequest {
                agifyioApi.fetchAge(
                    name = name,
                    countryId = countryId,
                )
            }.sendRequest()
}