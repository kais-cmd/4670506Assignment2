package com.example.a4670506assignment2

import com.example.a4670506assignment2.data.api.ApiService
import com.example.a4670506assignment2.data.model.DashboardResponse
import com.example.a4670506assignment2.data.model.LoginRequest
import com.example.a4670506assignment2.data.model.LoginResponse
import com.example.a4670506assignment2.data.model.MythologyEntity
import com.example.a4670506assignment2.data.repository.MythologyRepository
import com.example.a4670506assignment2.ui.dashboard.DashboardViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    private val fakeEntity = MythologyEntity(
        name = "Zeus",
        culture = "Greek",
        domain = "Sky and Thunder",
        symbol = "Thunderbolt",
        parentage = "Cronus and Rhea",
        romanEquivalent = "Jupiter",
        description = "King of the Olympian gods."
    )

    private val fakeApiService = object : ApiService {

        override suspend fun login(
            loginRequest: LoginRequest
        ): LoginResponse {
            throw NotImplementedError()
        }

        override suspend fun getDashboard(
            keypass: String
        ): DashboardResponse {
            return DashboardResponse(
                entities = listOf(fakeEntity),
                entityTotal = 1
            )
        }
    }

    private val repository = MythologyRepository(fakeApiService)
    private val viewModel = DashboardViewModel(repository)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun loadDashboard_returnsEntities() {
        var returnedEntities = emptyList<MythologyEntity>()

        viewModel.loadDashboard(
            keypass = "mythology",
            onSuccess = { returnedEntities = it },
            onError = {}
        )

        assertEquals(1, returnedEntities.size)
        assertEquals("Zeus", returnedEntities[0].name)
    }
}