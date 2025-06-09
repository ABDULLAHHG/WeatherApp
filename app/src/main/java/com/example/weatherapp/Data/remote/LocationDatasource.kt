package com.example.weatherapp.Data.remote


import android.Manifest
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*
import kotlinx.coroutines.tasks.await

class LocationDatasource(private val context: Context){

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getCurrentAddress(): String {
        return try {
            val location: Location? = fusedLocationClient.lastLocation.await()

            if (location != null) {
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses: List<Address> =
                    geocoder.getFromLocation(location.latitude, location.longitude, 1) ?: emptyList()

                if (addresses.isNotEmpty()) {
                    addresses[0].getAddressLine(0) ?: "No address line found"
                } else {
                    "No address found"
                }
            } else {
                "Location unavailable"
            }
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getCurrentCoordinates(): Pair<Double, Double>? {
        return try {
            val location: Location? = fusedLocationClient.lastLocation.await()
            if (location != null) {
                Pair(location.latitude, location.longitude)
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}
