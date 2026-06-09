package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

@Composable
fun AddPlantDialog(
    onDismiss: () -> Unit,
    onConfirm: (name: String, species: String, intervalDays: Int?) -> Unit
) {
    var nameInput by remember { mutableStateOf("") }
    var speciesInput by remember { mutableStateOf("") }
    var intervalInput by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Track new plant", style = MaterialTheme.typography.titleLarge) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = nameInput,
                    onValueChange = { nameInput = it },
                    label = { Text("Name") }
                )
                OutlinedTextField(
                    value = speciesInput,
                    onValueChange = { speciesInput = it },
                    label = { Text("Species") }
                )
                OutlinedTextField(
                    value = intervalInput,
                    onValueChange = { intervalValue ->
                        if (intervalValue.all { it.isDigit() }) {
                            intervalInput = intervalValue
                        }
                    },
                    label = { Text("Watering Interval") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (nameInput.isNotBlank() && speciesInput.isNotBlank()) {
                        val intervalInt = intervalInput.toIntOrNull()
                        onConfirm(nameInput, speciesInput, intervalInt)
                    }
                }
            ) {
                Text("Add Plant")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}