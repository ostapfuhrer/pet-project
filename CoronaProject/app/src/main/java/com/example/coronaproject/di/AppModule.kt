package com.example.coronaproject.di

import com.example.coronaproject.screens.details.CountryDetailsViewModel
import com.example.coronaproject.screens.list.CountryListViewModel
import com.example.coronaproject.screens.watchlist.WatchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        CountryListViewModel(get())
    }
    viewModel {
        CountryDetailsViewModel(get())
    }
    viewModel {
        WatchListViewModel(get())
    }
}