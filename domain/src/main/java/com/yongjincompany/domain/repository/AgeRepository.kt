package com.yongjincompany.domain.repository

import com.yongjincompany.domain.entity.age.AgeEntity
import kotlinx.coroutines.flow.Flow

interface AgeRepository {
    suspend fun fetchAge(
        name: String,
        countryId: String,
    ): Flow<AgeEntity>
}