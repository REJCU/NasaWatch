# NasaWatch – CP3406 

This is a basic Android app for viewing the various API offerings that NASA has to offer. 
It provides the structure for a simple tabular UI using **Jetpack Compose** and **Material Design 3**.
Will follow the design language of NASA (Typography, ColorScheme and other)

---
## Style Guide 
### Typefaces
- Helvectia Headings 
- Source Sans Pro Body

### Color Palette 
- Follows the NASA palette, which meets the highest standard of 508 color contrast requirements
- AGLS shaders to provide a backdrop to 

---
## Features 
- AGSL Shaders 

---
## Getting Started
### How to Run
1. Clone or download this repo  
2. Open in Android Studio  
3. Run on an emulator or physical device (API 36+ recommended)  

---
## Composables

### UtilityApp()
- Contains the screen layout using a Scaffold
- Toggles content between Utility and Settings

### UtilityScreen()
- Displays a simple counter (replace with your utility logic)  
- Includes a button to increment the counter

### SettingsScreen()
- Placeholder for user preferences or configuration  
- Can be extended to modify main screen behavior (e.g., theme, units, limits)  

---

## Key Concepts Covered

| Week | Concept                        | Used In                          |
|------|--------------------------------|----------------------------------|
| 1    | Kotlin + Android Studio         | MainActivity.kt |
| 2    | Jetpack Compose Layouts         | UtilityApp(), UtilityScreen(), SettingsScreen()   |
| 3    | Material Design 3               | CP3406_CP5603UtilityAppStarterTemplateTheme, MaterialTheme.typography |
| 4    | ViewModel | Not included in starter          |
| 5    | Retrofit  | Not included in starter          |

---
## 📚 License
This template is provided for educational use in CP3406.  
Feel free to modify and extend it for your assessment.
