package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class PlantSpeciesInfo(
    val id: Int,
    val commonName: String,
    val wateringInterval: Int,
    val description: String
)

data class UiState(
    val plants: List<TrackedPlant> = emptyList(),
    val sortByUrgency: Boolean = false,
    val isLoading: Boolean = false,
    val isAddPlantDialogVisible: Boolean = false
)

data class TrackedPlant(
    val id: String,
    val name: String,
    val species: String,
    val wateringIntervalDays: Int,
    val lastWatered: LocalDate
) {
    val daysUntilNextWater: Int
        @RequiresApi(Build.VERSION_CODES.O)
        get() {
            val nextWateringDate = lastWatered.plusDays(wateringIntervalDays.toLong())
            return ChronoUnit.DAYS.between(LocalDate.now(), nextWateringDate).toInt()
        }

    val needsWatering: Boolean
        @RequiresApi(Build.VERSION_CODES.O)
        get() = daysUntilNextWater < 0
}