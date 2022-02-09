package com.example.coronaproject.di

import androidx.room.Room
import com.example.coronaproject.data.api.ApiService
import com.example.coronaproject.data.database.AppDataBase
import com.example.coronaproject.data.database.CountryDao
import com.example.coronaproject.data.repository.CountryRemoteSource
import com.example.coronaproject.data.repository.CountryRepository
import com.example.coronaproject.model.CountryMapper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://services1.arcgis.com/"

val dataModule = module {
    single<Retrofit> {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    factory<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }
    factory {
        CountryRemoteSource(get())
    }
    factory {
        CountryMapper()
    }
    factory {
        CountryRepository(mapper = get(), countryRemoteSource = get(), countryDao = get())
    }
    single<AppDataBase> {
        Room.databaseBuilder(
            androidContext(), AppDataBase::class.java, "AppDB")
            .allowMainThreadQueries()
            .build()
    }
    fun getCountryDao(database: AppDataBase): CountryDao {
        return database.countryDao()
    }
    single<CountryDao> {
        getCountryDao(database = get())
    }

}


