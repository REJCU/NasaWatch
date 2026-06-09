package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.model.TrackedPlant
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.util.UUID

@RequiresApi(Build.VERSION_CODES.O)
class PlantViewModel : ViewModel() {

    private val mockPlants = mutableListOf(
        TrackedPlant(
            UUID.randomUUID().toString(),
            "Rose",
            "Crimson Siluetta",
            3,
            LocalDate.now().minusDays(1)
        ),
        TrackedPlant(UUID.randomUUID().toString(), "Lily", "Casa Blanca", 2, LocalDate.now().minusDays(2)),
        TrackedPlant(UUID.randomUUID().toString(), "Fern", "Boston Sword", 7, LocalDate.now().minusDays(0))
    )

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        refreshUiList()
    }

    fun showAddPlantDialog() {
        _uiState.update { it.copy(isAddPlantDialogVisible = true) }
    }

    fun dismissAddPlantDialog() {
        _uiState.update { it.copy(isAddPlantDialogVisible = false) }
    }

    fun addLocalPlant(name: String, species: String, wateringInterval: Int) {
        val newPlant = TrackedPlant(
            UUID.randomUUID().toString(),
            name,
            species,
            wateringInterval,
            LocalDate.now()
        )
        mockPlants.add(newPlant)
        dismissAddPlantDialog()
        refreshUiList()
    }

    fun waterPlant(plantId: String) {
        val index = mockPlants.indexOfFirst { it.id == plantId }
        if (index != -1) {
            val plant = mockPlants[index]
            mockPlants[index] = plant.copy(lastWatered = LocalDate.now())
        }
        refreshUiList()
    }

    fun toggleSort(sort: Boolean) {
        _uiState.update { it.copy(sortByUrgency = sort) }
        refreshUiList()
    }

    private fun refreshUiList() {
        val sortedList = if (_uiState.value.sortByUrgency) {
            mockPlants.sortedBy { it.daysUntilNextWater }
        } else {
            mockPlants.sortedBy { it.name }
        }
        _uiState.update { it.copy(plants = sortedList) }
    }
}