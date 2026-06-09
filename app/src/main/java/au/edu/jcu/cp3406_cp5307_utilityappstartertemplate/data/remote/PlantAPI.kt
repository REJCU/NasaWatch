package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.remote

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.model.PlantSpeciesInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface PlantAPI {
    @GET("species-list")
    suspend fun getPlantSpecies(
        @Query("key") apiKey: String,
        @Query("q") query: String
    ): List<PlantSpeciesInfo>
}