package com.pamlanjut.evolvance20.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pamlanjut.evolvance20.domain.usecase.bootcamp.GetBootcampRegisteredUseCase
import com.pamlanjut.evolvance20.utils.helper.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getBootcampRegisteredUseCase: GetBootcampRegisteredUseCase
): ViewModel() {
    private val _hasBootcamp = MutableStateFlow<Boolean>(false)
    val hasBootcamp: StateFlow<Boolean> = _hasBootcamp

    init {
        isUserHasBootcamp()
    }

    private fun isUserHasBootcamp() {
        viewModelScope.launch {
            getBootcampRegisteredUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        val hasBootcamp = result.data.isNotEmpty()
                        _hasBootcamp.value = true
                    }
                    is Resource.Error -> {
                        _hasBootcamp.value = false
                    }
                    else -> {}
                }
            }
        }
    }

}