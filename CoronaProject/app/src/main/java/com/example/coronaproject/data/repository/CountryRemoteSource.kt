package com.example.coronaproject.data.repository

import com.example.coronaproject.data.api.ApiService
import com.example.coronaproject.model.CountryModels

class CountryRemoteSource(private val apiService: ApiService) {
    suspend fun getCountryList(): CountryModels {
        return apiService.getCountryList()
    }
}