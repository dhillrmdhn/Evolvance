package com.pamlanjut.evolvance20.view.checker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import com.pamlanjut.evolvance20.data.session.SessionManager
import com.pamlanjut.evolvance20.domain.usecase.checker.IsLoggedInUseCase
import com.pamlanjut.evolvance20.view.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CheckerViewModel @Inject constructor(
    private val appViewModel: AppViewModel,
    private val isLoggedInUseCase: IsLoggedInUseCase,
    private val authRepository: AuthRepository
) : ViewModel() {

    val isLoggedIn: StateFlow<Boolean?> = isLoggedInUseCase(null)
        .onEach { loggedIn ->
            if (loggedIn) {
                try {
                    val user = authRepository.getUser()
                    SessionManager.setUser(user)
                } catch (e: Exception) {
                    SessionManager.setUser(null)
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )
}
