package com.pamlanjut.evolvance20.data.session

import com.pamlanjut.evolvance20.domain.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object SessionManager {
    private val _currentUser = MutableStateFlow<UserModel?>(null)
    val currentUser: StateFlow<UserModel?> = _currentUser

    fun setUser(user: UserModel?) {
        _currentUser.value = user
    }

    fun clearUser() {
        _currentUser.value = null
    }
}
