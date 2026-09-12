package com.example.a4670506assignment2.data.repository

import com.example.a4670506assignment2.data.api.ApiService
import com.example.a4670506assignment2.data.model.DashboardResponse
import com.example.a4670506assignment2.data.model.LoginRequest
import com.example.a4670506assignment2.data.model.LoginResponse

class MythologyRepository(
    private val apiService: ApiService
) {

    suspend fun login(
        username: String,
        password: String
    ): LoginResponse {
        return apiService.login(
            LoginRequest(
                username = username,
                password = password
            )
        )
    }

    suspend fun getDashboard(keypass: String): DashboardResponse {
        return apiService.getDashboard(keypass)
    }
}