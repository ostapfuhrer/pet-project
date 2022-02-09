package com.example.coronaproject.data.database

import androidx.room.*

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(countryEntity: CountryEntity): Long

    @Delete
    fun delete(countryEntity: CountryEntity): Int

    @Query("SELECT * FROM WATCHLIST_TABLE")
    fun getAllCountries(): List<CountryEntity>
}