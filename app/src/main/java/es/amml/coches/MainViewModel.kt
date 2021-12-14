package es.amml.coches

class MainViewModel(
    val getCars: GetCarsUseCase
) : BaseViewModel() {
    sealed class State : BaseViewModel.State() {
        object Loading : State()
        data class Error(val error: Throwable) : State()
        data class Loaded(val items: List<CarEntry>) : State()
    }

    /*data class Item(
        val title: String,
        val year: Int,

    ) {
        companion object {
            fun fromEntry(entry: CarEntry) = Item(
                title = entry.title,
                year = entry.year,
            )
        }
    }*/

    suspend fun initialState() {
        viewState.value = State.Loading
        val entries = getCars()
        viewState.value = State.Loaded(entries)
    }
}