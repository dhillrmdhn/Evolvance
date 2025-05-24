package com.pamlanjut.evolvance20.view.authentication

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pamlanjut.evolvance20.data.remote.api.RegisterRequest
import com.pamlanjut.evolvance20.domain.usecase.authentication.LoginUseCase
import com.pamlanjut.evolvance20.domain.usecase.authentication.RegisterUseCase
import com.pamlanjut.evolvance20.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    private val _registerState = MutableStateFlow<RegisterState>(RegisterState.Idle)
    val registerState: StateFlow<RegisterState> = _registerState

    private var _isChecked = MutableStateFlow<Boolean>(false)
    val isChecked: MutableStateFlow<Boolean> = _isChecked

    private var _registerRequest = MutableStateFlow<RegisterRequest>(RegisterRequest())
    val registerRequestState: StateFlow<RegisterRequest> = _registerRequest

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val token = loginUseCase.execute(email, password)
                _loginState.value = LoginState.Success(token.accessToken)
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun register(
        request: RegisterRequest
    ) {
        viewModelScope.launch {
            _registerState.value = RegisterState.Loading

            if (request.password != request.password_confirmation) {
                _registerState.value = RegisterState.Error("Password does not match")
                return@launch
            } else {
                when(
                    val response = registerUseCase.execute(request)
                ) {
                    is Result.Success -> _registerState.value = RegisterState.Success(response.data)
                    is Result.Error -> _registerState.value = RegisterState.Error(response.message)
                }
            }
        }
    }

    fun updateCheck(state: Boolean) {
        _isChecked.value = state
    }

    fun updateRegisterRequest(request: RegisterRequest) {
        _registerRequest.value = request
    }
}

sealed class LoginState {
    data object Idle : LoginState()
    data object Loading : LoginState()
    data class Success(
        val token: String
    ) : LoginState()
    data class Error(
        val message: String
    ) : LoginState()
}

sealed class RegisterState {
    data object Idle : RegisterState()
    data object Loading : RegisterState()
    data class Success(
        val message: String
    ) : RegisterState()
    data class Error(
        val message: String
    ) : RegisterState()
}