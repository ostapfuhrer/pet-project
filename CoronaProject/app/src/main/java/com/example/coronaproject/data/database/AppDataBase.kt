package com.example.coronaproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun countryDao(): CountryDao

}