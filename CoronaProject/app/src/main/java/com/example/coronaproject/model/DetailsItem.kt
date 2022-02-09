package com.example.coronaproject.model

data class DetailsItem(
    val id:Int,
    val nameOfCountry: String,
    val confirmedCases: Long,
    val deaths: Long,
    val incidentRate: Double,
    val mortalityRate: Double,
    val iso3: String,
    val lat: Double,
    val long_: Double,
    val lastUpdate: String?,
)
