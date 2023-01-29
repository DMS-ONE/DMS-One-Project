package com.yongjincompany.data.repository.age

import com.yongjincompany.data.remote.datasource.RemoteAgeDataSource
import com.yongjincompany.data.remote.response.age.AgeResponse
import com.yongjincompany.domain.entity.age.AgeEntity
import com.yongjincompany.domain.repository.AgeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AgeRepositoryImpl @Inject constructor(
    private val remoteAgeDataSource: RemoteAgeDataSource,
) : AgeRepository {
    override suspend fun fetchAge(
        name: String,
    ): Flow<AgeEntity> =
        flow { emit(remoteAgeDataSource.fetchAge(name).toEntity()) }

    private fun AgeResponse.toEntity() =
        AgeEntity(
            age = age,
            count = count,
            name = name,
        )
}