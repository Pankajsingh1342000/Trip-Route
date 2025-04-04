package com.example.triproute.domain.usecase

import com.example.triproute.domain.model.Location
import com.example.triproute.domain.repository.LocationRepository

class GetLocationsUseCase(private val repository: LocationRepository) {
    suspend operator fun invoke(): List<Location> {
        return repository.getLocations()
    }
}