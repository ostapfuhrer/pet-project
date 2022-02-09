package com.example.coronaproject.screens.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coronaproject.databinding.FragmentCountryDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryDetailsFragment : Fragment() {
    private var _binding: FragmentCountryDetailsBinding? = null
    private val binding get() = _binding!!
    private val countryDetailsViewModel by viewModel<CountryDetailsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCountryDetailsBinding.inflate(inflater, container, false)
        //key to const Country
        arguments?.getString("Country")?.let { countryDetailsViewModel.getCountryDetails(it) }
        arguments?.getBoolean("is watch list")?.let { isWatchList ->
            if (isWatchList) {
                binding.btnDel.visibility = View.VISIBLE
            } else binding.btnAdd.visibility = View.VISIBLE
        }
        bind()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun bind() {
        countryDetailsViewModel.detailsCountry.observe(viewLifecycleOwner) { countryDetails ->
            binding.tvCountryName.text = "Country region: " + countryDetails.nameOfCountry
            binding.tvConfirmedCases.text =
                "Confirmed cases: " + countryDetails.confirmedCases.toString()
            binding.tvDeathCases.text = "Deaths: " + countryDetails.deaths.toString()
            binding.tvIncidentCases.text =
                "Incident rate: " + countryDetails.incidentRate.toString()
            binding.tvMortalityCases.text =
                "Mortality rate: " + countryDetails.mortalityRate.toString()
            binding.tvCountryCode.text = "Country code: " + countryDetails.iso3
            binding.tvLatitude.text = "Latitude: " + countryDetails.lat.toString()
            binding.tvLong.text = "Longtitude: " + countryDetails.long_.toString()
            binding.tvLastUpdated.text = "Last update: " + countryDetails.lastUpdate
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener {
            countryDetailsViewModel.saveCountryDetail()
        }
        binding.btnDel.setOnClickListener {
            countryDetailsViewModel.deleteCountryDetail()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}