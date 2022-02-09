package com.example.coronaproject.screens.watchlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronaproject.data.repository.CountryRepository
import com.example.coronaproject.model.CountryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WatchListViewModel(private val repository: CountryRepository) : ViewModel() {
    val countryWatchList: MutableLiveData<List<CountryItem>> = MutableLiveData()

    fun getCountryFromStorage() {
        viewModelScope.launch(Dispatchers.IO) {
            countryWatchList.postValue(repository.getCountryItemFromDb())
        }
    }
}