package com.example.coronaproject.model

import android.annotation.SuppressLint
import com.example.coronaproject.data.database.CountryEntity
import java.sql.Date
import java.text.SimpleDateFormat

class CountryMapper {
    fun getCountryItems(countryModels: CountryModels): List<CountryItem> {
        return countryModels.features.map { feature ->
            CountryItem(
                feature.attributes.countryRegion,
                feature.attributes.confirmed,
                getDateTime(feature.attributes.lastUpdate)
            )
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDateTime(s: Long): String? {
        return try {
            val sdf = SimpleDateFormat("dd MMM yyyy HH:mm")
            val netDate = Date(s)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }

    fun getCountryDetails(attributes: Attributes): DetailsItem {
        return DetailsItem(
            attributes.uid,
            attributes.countryRegion,
            attributes.confirmed,
            attributes.deaths,
            attributes.incidentRate,
            attributes.incidentRate,
            attributes.iso3,
            attributes.lat,
            attributes.long_,
            getDateTime(attributes.lastUpdate)
        )
    }

    fun getCountryFromEntities(list: List<CountryEntity>): List<CountryItem> {
        return list.map { entity ->
            CountryItem(
                entity.nameOfCountry,
                entity.confirmedCases,
                entity.lastUpdate,
            )
        }
    }

    fun getDetailToEntity(detailsItem: DetailsItem): CountryEntity {
        return CountryEntity(
            detailsItem.id.toLong(),
            detailsItem.iso3,
            detailsItem.nameOfCountry,
            detailsItem.confirmedCases,
            detailsItem.deaths,
            detailsItem.incidentRate,
            detailsItem.mortalityRate,
            detailsItem.lat,
            detailsItem.long_,
            detailsItem.lastUpdate

        )
    }
}
