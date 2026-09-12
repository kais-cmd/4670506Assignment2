package com.example.a4670506assignment2.di

import com.example.a4670506assignment2.data.api.ApiService
import com.example.a4670506assignment2.data.repository.MythologyRepository
import com.example.a4670506assignment2.ui.dashboard.DashboardViewModel
import com.example.a4670506assignment2.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://nit3213apinew.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }

    single {
        MythologyRepository(get())
    }

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        DashboardViewModel(get())
    }
}