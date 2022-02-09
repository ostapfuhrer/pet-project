package com.example.coronaproject.screens.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coronaproject.R
import com.example.coronaproject.screens.adapters.ViewPagerAdapter
import com.example.coronaproject.databinding.FragmentRootBinding
import com.google.android.material.tabs.TabLayoutMediator

class RootFragment : Fragment() {
    private var _binding: FragmentRootBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRootBinding.inflate(inflater, container, false)
        adapter = ViewPagerAdapter(this)
        with(binding) {
            viewPager2.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                when (position) {
                    0 -> tab.text = getString(R.string.all_countries)
                    else -> tab.text = getString(R.string.watched_countries)
                }
            }.attach()
        }
        return binding.root

    }
}