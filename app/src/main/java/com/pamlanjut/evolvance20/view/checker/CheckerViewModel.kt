package com.pamlanjut.evolvance20.view.checker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pamlanjut.evolvance20.domain.usecase.checker.IsLoggedInUseCase
import com.pamlanjut.evolvance20.view.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckerViewModel @Inject constructor(
    private val appViewModel: AppViewModel,
    private val isLoggedInUseCase: IsLoggedInUseCase
) : ViewModel() {
    val isLoggedIn: StateFlow<Boolean?> = isLoggedInUseCase(null)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )
}