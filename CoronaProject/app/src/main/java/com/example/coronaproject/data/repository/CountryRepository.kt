package com.example.coronaproject.data.repository

import com.example.coronaproject.data.database.CountryDao
import com.example.coronaproject.model.CountryItem
import com.example.coronaproject.model.CountryMapper
import com.example.coronaproject.model.DetailsItem

class CountryRepository(
    private val mapper: CountryMapper,
    private val countryRemoteSource: CountryRemoteSource,
    private val countryDao: CountryDao,
) {
    suspend fun getCountryItem(): List<CountryItem> {
        val countryModels = countryRemoteSource.getCountryList()
        return mapper.getCountryItems(countryModels)
    }

    suspend fun getCountryDetails(country: String): DetailsItem {
        val countryModels = countryRemoteSource.getCountryList()
        val feature = countryModels.features.first { feature ->
            feature.attributes.countryRegion == country
        }
        return mapper.getCountryDetails(feature.attributes)
    }

    suspend fun saveCountry(detailsItem: DetailsItem) {
        countryDao.insert(mapper.getDetailToEntity(detailsItem))
    }

    suspend fun deleteCountry(detailsItem: DetailsItem) {
        countryDao.delete(mapper.getDetailToEntity(detailsItem))
    }

    suspend fun getCountryItemFromDb(): List<CountryItem> {
        return mapper.getCountryFromEntities(
            countryDao.getAllCountries()
        )
    }
}