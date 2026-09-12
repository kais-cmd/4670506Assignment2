package com.example.a4670506assignment2

import com.example.a4670506assignment2.data.api.ApiService
import com.example.a4670506assignment2.data.model.DashboardResponse
import com.example.a4670506assignment2.data.model.LoginRequest
import com.example.a4670506assignment2.data.model.LoginResponse
import com.example.a4670506assignment2.data.repository.MythologyRepository
import com.example.a4670506assignment2.ui.login.LoginViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginViewModelTest {

    private val fakeApiService = object : ApiService {

        override suspend fun login(
            loginRequest: LoginRequest
        ): LoginResponse {
            return LoginResponse("mythology")
        }

        override suspend fun getDashboard(
            keypass: String
        ): DashboardResponse {
            throw NotImplementedError()
        }
    }

    private val repository = MythologyRepository(fakeApiService)
    private val viewModel = LoginViewModel(repository)

    @Test
    fun emptyUsername_returnsValidationError() {
        var errorMessage = ""

        viewModel.login(
            username = "",
            password = "Kim",
            onSuccess = {},
            onError = { errorMessage = it }
        )

        assertEquals(
            "Please enter your username and password.",
            errorMessage
        )
    }

    @Test
    fun emptyPassword_returnsValidationError() {
        var errorMessage = ""

        viewModel.login(
            username = "4670506",
            password = "",
            onSuccess = {},
            onError = { errorMessage = it }
        )

        assertEquals(
            "Please enter your username and password.",
            errorMessage
        )
    }
}