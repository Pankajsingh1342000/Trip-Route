package com.example.triproute.domain.repository

import com.example.triproute.domain.model.Location


interface LocationRepository {
    suspend fun addLocation(location: Location)
    suspend fun deleteLocation(location: Location)
    suspend fun getLocations(): List<Location>
}