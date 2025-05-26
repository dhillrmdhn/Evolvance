package com.pamlanjut.evolvance20.view.authentication

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pamlanjut.evolvance20.data.remote.api.RegisterRequest
import com.pamlanjut.evolvance20.data.remote.api.VerifyOtpRequest
import com.pamlanjut.evolvance20.domain.usecase.authentication.LoginUseCase
import com.pamlanjut.evolvance20.domain.usecase.authentication.RegisterUseCase
import com.pamlanjut.evolvance20.domain.usecase.authentication.VerifyOtpUseCase
import com.pamlanjut.evolvance20.utils.Result
import com.pamlanjut.evolvance20.view.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
    private val verifyOtpUseCase: VerifyOtpUseCase,
    private val appViewModel: AppViewModel
) : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    private val _registerState = MutableStateFlow<RegisterState>(RegisterState.Idle)
    val registerState: StateFlow<RegisterState> = _registerState

    private val _authUiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val authUiState: StateFlow<AuthUiState> = _authUiState

    private var _isChecked = MutableStateFlow(false)
    val isChecked: MutableStateFlow<Boolean> = _isChecked

    private var _registerRequest = MutableStateFlow(RegisterRequest())
    val registerRequestState: StateFlow<RegisterRequest> = _registerRequest

    fun login(email: String, password: String) {
        viewModelScope.launch {
            appViewModel.showLoading()
            try {
                val token = loginUseCase.execute(email, password)
                _loginState.value = LoginState.Success(token.accessToken)
                appViewModel.hideLoading()
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "Unknown error")
                appViewModel.hideLoading()
            }
        }
    }

    fun register(
        request: RegisterRequest
    ) {
        viewModelScope.launch {
            appViewModel.showLoading()

            if (request.password != request.password_confirmation) {
                _registerState.value = RegisterState.Error("Password does not match")
                appViewModel.hideLoading()
                return@launch
            } else {
                when(
                    val response = registerUseCase.execute(request)
                ) {
                    is Result.Success -> {
                        _registerState.value = RegisterState.Success(response.data)
                        appViewModel.hideLoading()
                    }
                    is Result.Error -> {
                        _registerState.value = RegisterState.Error(response.message)
                        appViewModel.hideLoading()
                    }
                }
            }
        }
    }

    fun verifyOtp(
        request: VerifyOtpRequest
    ) {
        viewModelScope.launch {
            appViewModel.showLoading()

            when(
                val response = verifyOtpUseCase.execute(
                    request
                )
            ) {
                is Result.Success -> {
                    _authUiState.value = AuthUiState.Success(response.data)
                    appViewModel.hideLoading()
                }
                is Result.Error -> {
                    _authUiState.value = AuthUiState.Error(response.message)
                    appViewModel.hideLoading()
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

    fun resetRegisterState() {
        _registerState.value = RegisterState.Idle
    }

    fun resetState() {
        _authUiState.value = AuthUiState.Loading
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

sealed class AuthUiState {
    data object Idle : AuthUiState()
    data object Loading : AuthUiState()
    data class Success(
        val token: String
    ) : AuthUiState()
    data class Error(
        val message: String
    ) : AuthUiState()
}