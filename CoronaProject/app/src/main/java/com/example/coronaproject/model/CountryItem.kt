package com.example.coronaproject.model

data class CountryItem(
    val nameOfCountry: String,
    val confirmedCases: Long,
    val lastUpdate: String?,
)
