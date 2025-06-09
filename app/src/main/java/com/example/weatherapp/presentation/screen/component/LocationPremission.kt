//package com.example.weatherapp.presentation.screen.component
//
//
//
//// Add these imports
//import android.Manifest
//import android.content.pm.PackageManager
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//
//private val LOCATION_PERMISSION_REQUEST_CODE = 123
//
//private fun checkLocationPermission() {
//    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
//    } else {
//        // Permission already granted, proceed with getting location
//        getLastLocation()
//    }
//}
//
//override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//    if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
//        if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//            // Permission was granted, proceed with getting location
//            getLastLocation()
//        } else {
//            // Permission denied, handle accordingly (e.g., show a message)
//            // You might want to explain why you need the permission
//        }
//    }
//}