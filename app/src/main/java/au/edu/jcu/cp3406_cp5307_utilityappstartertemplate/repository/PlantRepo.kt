package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.repository

import android.os.Build
import androidx.annotation.RequiresApi
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.model.TrackedPlant
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.remote.PlantAPI
import java.time.LocalDate
import java.util.UUID

class PlantRepo(private val api: PlantAPI) {
    @RequiresApi(Build.VERSION_CODES.O)
    private val _trackedPlants = mutableListOf(
        TrackedPlant(
            UUID.randomUUID().toString(),
            "Rose",
            "Crimson Siluetta",
            3,
            LocalDate.now().minusDays(1)
        ),
        TrackedPlant(
            UUID.randomUUID().toString(),
            "Lily",
            "Casa Blanca",
            2,
            LocalDate.now().minusDays(2)
        )
    )

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTrackedPlants(): List<TrackedPlant> = _trackedPlants.toList()

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateWateringTime(plantId: String) {
        val index = _trackedPlants.indexOfFirst { it.id == plantId }
        if (index != -1) {
            val plant = _trackedPlants[index]
            _trackedPlants[index] = plant.copy(lastWatered = LocalDate.now())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addNewPlant(name: String, species: String, interval: Int) {
        val newPlant = TrackedPlant(
            id = UUID.randomUUID().toString(),
            name = name,
            species = species,
            wateringIntervalDays = interval,
            lastWatered = LocalDate.now()
        )
        _trackedPlants.add(newPlant)
    }
}