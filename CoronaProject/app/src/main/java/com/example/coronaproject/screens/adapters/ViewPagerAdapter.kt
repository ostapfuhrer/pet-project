package com.example.coronaproject.screens.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.coronaproject.screens.list.FirstTabFragmentCountry
import com.example.coronaproject.screens.root.RootFragment
import com.example.coronaproject.screens.watchlist.SecondTabWatchListFragment

class ViewPagerAdapter(rootFragment: RootFragment) :
    FragmentStateAdapter(rootFragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                //rename class like countries
                FirstTabFragmentCountry()
            }//same
            else -> {
                SecondTabWatchListFragment()
            }
        }
    }
}
