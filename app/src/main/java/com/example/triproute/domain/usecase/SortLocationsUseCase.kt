package com.example.triproute.domain.usecase

import com.example.triproute.domain.model.Location
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class SortLocationsUseCase {
    operator fun invoke(locations: List<Location>, ascending: Boolean): List<Location> {
        if (locations.isEmpty()) return locations

        val base = locations.first()
        return locations.sortedBy {
            val dist = distanceBetween(base.latitude, base.longitude, it.latitude, it.longitude)
            if (ascending) dist else -dist
        }
    }

    private fun distanceBetween(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val earthRadius = 6371
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = sin(dLat / 2).pow(2.0) + cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) *
                sin(dLon / 2).pow(2.0)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return earthRadius * c
    }
}