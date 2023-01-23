package com.yongjincompany.app.feature.dledledle.seunghoon

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.yongjincompany.app.R
import com.yongjincompany.app.databinding.ActivitySeunghoonBinding
import com.yongjincompany.app.util.BaseActivity
import com.yongjincompany.app.util.repeatOnStarted
import com.yongjincompany.app.util.visible
import com.yongjincompany.app.viewmodel.age.FetchAgeViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.yongjincompany.app.viewmodel.age.FetchAgeViewModel.FetchAgeEvent
import com.yongjincompany.domain.entity.age.AgeEntity

@AndroidEntryPoint
class SeunghoonActivity : BaseActivity<ActivitySeunghoonBinding>(
    R.layout.activity_seunghoon,
) {
    private val vm: FetchAgeViewModel by viewModels()

    override fun initView() {
        super.initView()
        initStartButton()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repeatOnStarted {
            vm.fetchAgeEvent.collect { event -> handleEvent(event) }
        }
    }

    private fun initStartButton() {
        with(binding) {
            btnActivitySeunghoonStart.setOnClickListener {
                etActivitySeunghoonName.text.toString().run {
                    if(this.isNotBlank()){
                        vm.fetchAge(this)
                    }
                }
            }
        }
    }

    private fun handleEvent(event: FetchAgeEvent) {
        when (event) {
            is FetchAgeEvent.FetchAge -> setAgeTextView(event.ageEntity)
            is FetchAgeEvent.ErrorMessage -> {
                showShortToast(event.errorMessage)
            }
        }
    }

    private fun setAgeTextView(ageData: AgeEntity) {
        with(binding) {
            ageData.run {
                tvActivitySeunghoonAge.text = setParseInt(ageData.age)
                tvActivitySeunghoonCount.text = setParseInt(ageData.count)
                tvActivitySeunghoonAge.visible()
                tvActivitySeunghoonCount.visible()
                tvActivitySeunghoonAgeUnit.visible()
                tvActivitySeunghoonCountUnit.visible()
            }
        }
    }

    private fun setParseInt(
        text: Int?,
    ): String = Integer.parseInt(text.toString()).toString()
}