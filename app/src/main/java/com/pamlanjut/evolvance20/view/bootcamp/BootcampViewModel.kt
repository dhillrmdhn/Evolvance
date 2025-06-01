package com.pamlanjut.evolvance20.view.bootcamp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pamlanjut.evolvance20.domain.model.Bootcamp
import com.pamlanjut.evolvance20.domain.usecase.bootcamp.GetBootcampDataUseCase
import com.pamlanjut.evolvance20.domain.usecase.bootcamp.GetBootcampRegisteredUseCase
import com.pamlanjut.evolvance20.utils.helper.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BootcampViewModel @Inject constructor(
    private val getBootcampsUseCase: GetBootcampDataUseCase,
    private val getBootcampDataUseCase: GetBootcampRegisteredUseCase
) : ViewModel() {
    // Bootcamps State
    private val _state = MutableStateFlow<Resource<List<Bootcamp>>>(Resource.Idle)
    val state: StateFlow<Resource<List<Bootcamp>>> = _state.asStateFlow()
    init {
        fetchBootcamps()
    }
    private fun fetchBootcamps() {
        viewModelScope.launch {
            getBootcampsUseCase().collect { result ->
                _state.value = result
            }
        }
    }

    // Bootcamps Registered State
    private val _registeredState = MutableStateFlow<Resource<List<Bootcamp>>>(Resource.Idle)
    val registeredState: StateFlow<Resource<List<Bootcamp>>> = _registeredState.asStateFlow()
    fun fetchBootcampRegistered() {
        println("🚀 fetchBootcampRegistered() called")

        viewModelScope.launch {
            getBootcampDataUseCase().collect { result ->
                println("✅ Received result for registered: $result")
                _registeredState.value = result
            }
        }
    }
}
