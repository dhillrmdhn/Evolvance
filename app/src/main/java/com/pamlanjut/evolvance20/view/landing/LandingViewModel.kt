package com.pamlanjut.evolvance20.view.landing

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pamlanjut.evolvance20.domain.model.LandingProgressModel
import com.pamlanjut.evolvance20.domain.usecase.landing.GetContentByStepUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val getContentByStepUseCase: GetContentByStepUseCase
) : ViewModel() {
    private val _count = mutableStateOf(0)
    val count: State<Int> = _count

    val textData: State<LandingProgressModel> = derivedStateOf {
        getContentByStepUseCase(_count.value)
    }

    fun increment() {
        if (_count.value < 2) {
            _count.value++
        }
    }

    fun decrement() {
        if (_count.value > 0) {
            _count.value--
        }
    }
}