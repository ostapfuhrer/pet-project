package com.example.coronaproject.screens.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coronaproject.R
import com.example.coronaproject.databinding.FragmentSecondTabWatchListBinding
import com.example.coronaproject.screens.list.CountryStatsRecyclerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondTabWatchListFragment : Fragment() {

    private var _binding: FragmentSecondTabWatchListBinding? = null
    private val binding get() = _binding!!
    private val watchListViewModel by viewModel<WatchListViewModel>()
    lateinit var adapterStats: CountryStatsRecyclerAdapter
    private var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSecondTabWatchListBinding.inflate(inflater, container, false)
        watchListViewModel.getCountryFromStorage()
        val bundle = Bundle()
        adapterStats = CountryStatsRecyclerAdapter(onItemClick = { countryName ->
            bundle.putString("Country", countryName)
            bundle.putBoolean("is watch list", true)

            navController?.navigate(R.id.action_rootFragment_to_countryDetailsFragment, bundle)
        })
        binding.rvSecondTab.layoutManager = LinearLayoutManager(context)
        binding.rvSecondTab.adapter = adapterStats
        watchListViewModel.getCountryFromStorage()
        watchListViewModel.countryWatchList.observe(viewLifecycleOwner) { list ->
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