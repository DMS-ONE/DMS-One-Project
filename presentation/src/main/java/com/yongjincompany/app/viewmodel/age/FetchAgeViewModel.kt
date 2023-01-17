package com.yongjincompany.app.viewmodel.age

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincompany.app.util.MutableEventFlow
import com.yongjincompany.app.util.asEventFlow
import com.yongjincompany.domain.entity.age.AgeEntity
import com.yongjincompany.domain.param.AgeParam
import com.yongjincompany.domain.usecase.age.AgeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.yongjincompany.app.viewmodel.age.FetchAgeViewModel.FetchAgeEvent.FetchAge

@HiltViewModel
class FetchAgeViewModel @Inject constructor(
    private val ageUseCase: AgeUseCase,
) : ViewModel() {

    private val _fetchAgeEvent = MutableEventFlow<FetchAgeEvent>()
    val fetchAgeEvent = _fetchAgeEvent.asEventFlow()

    fun fetchAge(
        name: String,
        countryId: String,
    ) {
        viewModelScope.launch(IO) {
            kotlin.runCatching {
                ageUseCase.execute(
                    AgeParam(
                        name = name,
                        countryId = countryId,
                    )
                ).collect {
                    event(FetchAge(it.toData()))
                }
            }
        }
    }

    private fun event(event: FetchAgeEvent) {
        viewModelScope.launch(IO) {
            _fetchAgeEvent.emit(event)
        }
    }

    sealed class FetchAgeEvent {

        data class FetchAge(val ageEntity: AgeEntity) : FetchAgeEvent()

        data class ErrorMessage(val errorMessage: String) : FetchAgeEvent()
    }

    private fun AgeEntity.toData() =
        AgeEntity(
            age = age,
            count = count,
            countryId = countryId,
            name = name,
        )
}