package com.example.coronaproject.screens.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronaproject.data.repository.CountryRepository
import com.example.coronaproject.model.CountryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryListViewModel(private val repository: CountryRepository) : ViewModel() {

    val myCountryList: MutableLiveData<List<CountryItem>> = MutableLiveData()
    fun getCountryList() {
        viewModelScope.launch(Dispatchers.IO) {
            myCountryList.postValue( repository.getCountryItem())
        }
    }
}