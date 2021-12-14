package es.amml.coches

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCarsUseCase(
    val dispatcher: CoroutineDispatcher
) {
    private val sampleEntries = listOf(
        CarEntry("Toyota", 2020),
        CarEntry("Suzuki", 2019),
        CarEntry("Mitsubishi", 2018),
        CarEntry("Nissan", 2021),
        CarEntry("Kia", 2020)
    )

    suspend operator fun invoke(): List<CarEntry> {
        withContext(Dispatchers.IO) {
            Thread.sleep(3000)
        }
        return sampleEntries
    }
}
