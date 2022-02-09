package com.example.coronaproject.model

import com.google.gson.annotations.SerializedName

data class CountryModels(
    @SerializedName(value = "objectIdFieldName")
    val objectIDFieldName: String,

    @SerializedName(value = "uniqueIdField")
    val uniqueIDField: UniqueIDField,

    @SerializedName(value = "globalIdFieldName")
    val globalIDFieldName: String,

    val geometryType: String,
    val spatialReference: SpatialReference,
    val fields: List<Field>,
    val features: List<Feature>,
)

data class Feature(
    val attributes: Attributes,
    val geometry: Geometry? = null,
)

data class Attributes(
    @SerializedName(value = "Country_Region")
    val countryRegion: String,


    @SerializedName(value = "Last_Update")
    val lastUpdate: Long,


    @SerializedName(value = "Deaths")
    val deaths: Long,


    @SerializedName(value = "Recovered")
    val recovered: Any? = null,


    @SerializedName(value = "Active")
    val active: Any? = null,


    @SerializedName(value = "Incident_Rate")
    val incidentRate: Double,


    @SerializedName(value = "Mortality_Rate")
    val mortalityRate: Double,


    @SerializedName(value = "Confirmed")
    val confirmed: Long,


    @SerializedName(value = "UID")
    val uid: Int,


    @SerializedName(value = "ISO3")
    val iso3: String,


    @SerializedName(value = "Lat")
    val lat: Double,


    @SerializedName(value = "Long_")
    val long_: Double,
)

data class Geometry(
    val x: Double,
    val y: Double,
)

data class Field(
    val name: String,
    val type: String,
    val alias: String,
    val sqlType: String,
    val length: Long? = null,
    val domain: Any? = null,
    val defaultValue: Any? = null,
)

data class SpatialReference(
    val wkid: Long,
    val latestWkid: Long,
)

data class UniqueIDField(
    val name: String,
    val isSystemMaintained: Boolean,
)