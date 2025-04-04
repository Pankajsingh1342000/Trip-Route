package com.example.triproute.domain.usecase

import com.example.triproute.domain.model.Location
import com.example.triproute.domain.repository.LocationRepository

class AddLocationUseCase(private val repository: LocationRepository) {
    suspend operator fun invoke(location: Location) {
        repository.addLocation(location)
    }
}