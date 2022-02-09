package com.example.coronaproject.screens.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronaproject.data.repository.CountryRepository
import com.example.coronaproject.model.DetailsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryDetailsViewModel(private val repository: CountryRepository) : ViewModel() {
    val detailsCountry: MutableLiveData<DetailsItem> = MutableLiveData()
    fun getCountryDetails(countryName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            detailsCountry.postValue(repository.getCountryDetails(countryName))
        }
    }

    fun saveCountryDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            detailsCountry.value?.let { repository.saveCountry(it) }
        }
    }

    fun deleteCountryDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            detailsCountry.value?.let { repository.deleteCountry(it) }
        }
    }
}