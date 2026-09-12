package com.example.a4670506assignment2.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4670506assignment2.data.model.MythologyEntity
import com.example.a4670506assignment2.data.repository.MythologyRepository
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repository: MythologyRepository
) : ViewModel() {

    fun loadDashboard(
        keypass: String,
        onSuccess: (List<MythologyEntity>) -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboard(keypass)
                onSuccess(response.entities)
            } catch (exception: Exception) {
                onError("Unable to load dashboard data.")
            }
        }
    }
}