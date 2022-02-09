package com.example.coronaproject.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coronaproject.R
import com.example.coronaproject.databinding.FragmentFirstTabCountryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstTabFragmentCountry : Fragment() {

    private var _binding: FragmentFirstTabCountryBinding? = null
    private val binding get() = _binding!!
    lateinit var adapterStats: CountryStatsRecyclerAdapter
    private var navController: NavController? = null
    private val countryListViewModel by viewModel<CountryListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFirstTabCountryBinding.inflate(inflater, container, false)
        val bundle = Bundle()
        adapterStats = CountryStatsRecyclerAdapter(onItemClick = { countryName ->
            bundle.putString("Country", countryName)
            bundle.putBoolean("is watch list",false)
            navController?.navigate(R.id.action_rootFragment_to_countryDetailsFragment, bundle)
        })
        binding.rvFirstTab.layoutManager = LinearLayoutManager(context)
        binding.rvFirstTab.adapter = adapterStats
        countryListViewModel.getCountryList()
        countryListViewModel.myCountryList.observe(viewLifecycleOwner) { list ->
            adapterStats.setCountryList(list)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}