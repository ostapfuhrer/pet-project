package com.example.coronaproject.data.api

import com.example.coronaproject.model.CountryModels
import retrofit2.http.GET

interface ApiService {
    @GET("0MSEUqKaxRlEPj5g/arcgis/rest/services/ncov_cases2_v1/FeatureServer/2/query?where=1%3D1&outFields=Deaths,Recovered,Active,Incident_Rate,Mortality_Rate,UID,ISO3,Lat,Long_,Country_Region,Last_Update,Confirmed&outSR=4326&f=json")
    suspend fun getCountryList():CountryModels
}