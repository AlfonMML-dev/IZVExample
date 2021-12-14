package es.amml.coches

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class MainViewModelTest{
    private val coroutineScope = MainScope()
    private val mockUseCase: GetCarsUseCase =
        GetCarsUseCase(Dispatchers.Unconfined)

    @Test
    fun `should transact to Loading state when ViewModel is initialized`() = runBlocking {
        val viewModel = MainViewModel(mockUseCase)

        coroutineScope.launch {
            viewModel.initialState()
        }

        assertTrue(viewModel.state() is Seasons.state)
    }

}