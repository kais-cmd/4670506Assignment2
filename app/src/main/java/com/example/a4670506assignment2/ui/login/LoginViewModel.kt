package com.example.a4670506assignment2.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4670506assignment2.data.repository.MythologyRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: MythologyRepository
) : ViewModel() {

    fun login(
        username: String,
        password: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        if (username.isBlank() || password.isBlank()) {
            onError("Please enter your username and password.")
            return
        }

        viewModelScope.launch {
            try {
                val response = repository.login(username, password)
                onSuccess(response.keypass)
            } catch (exception: Exception) {
                onError("Login failed. Please check your username and password.")
            }
        }
    }
}