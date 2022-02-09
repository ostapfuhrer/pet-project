package com.example.coronaproject.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watchlist_table")
data class CountryEntity(
    @PrimaryKey
    val id:Long,
    val iso3: String,
    val nameOfCountry: String,
    val confirmedCases: Long,
    val deaths: Long,
    val incidentRate: Double,
    val mortalityRate: Double,
    val lat: Double,
    val long_: Double,
    val lastUpdate: String?,
)

