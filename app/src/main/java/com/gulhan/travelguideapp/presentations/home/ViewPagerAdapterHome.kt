package com.gulhan.travelguideapp.presentations.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gulhan.travelguideapp.presentations.home.fragments.AllFragment
import com.gulhan.travelguideapp.presentations.home.fragments.FlightsFragment
import com.gulhan.travelguideapp.presentations.home.fragments.HotelsFragment
import com.gulhan.travelguideapp.presentations.home.fragments.TransportationsFragment


class ViewPagerAdapterHome(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AllFragment()
            1 -> return FlightsFragment()
            2 -> return HotelsFragment()
        }
        return TransportationsFragment()
    }
}