package com.example.weatherapp.logic.reposiotry

import com.example.weatherapp.logic.entity.LocationInfo

interface LocationRepository {
    suspend fun getCurrentLocation(): LocationInfo
}