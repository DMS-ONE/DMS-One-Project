package com.yongjincompany.domain.usecase.age

import com.yongjincompany.domain.entity.age.AgeEntity
import com.yongjincompany.domain.repository.AgeRepository
import com.yongjincompany.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AgeUseCase @Inject constructor(
    private val ageRepository: AgeRepository,
) : UseCase<String, Flow<AgeEntity>>() {
    override suspend fun execute(data: String): Flow<AgeEntity> =
        ageRepository.fetchAge(data)
}