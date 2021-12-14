package es.amml.coches

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCarsUseCase(
    val dispatcher: CoroutineDispatcher
) {
    private val sampleEntries = emptyList<CarEntry>()

    suspend operator fun invoke(): List<CarEntry> {
        withContext(Dispatchers.IO) {
            Thread.sleep(3000)
        }
        return sampleEntries
    }
}
