package com.gulhan.travelguideapp.presentations.trip

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.doOnAttach
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentTripBinding

class TripFragment : Fragment() {

    private lateinit var binding : FragmentTripBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_trip,container,false)

        val adapter = ViewPagerAdapterTrip(parentFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter
        binding.viewpager.doOnAttach {
            binding.viewpager.setCurrentItem(0, true)
        }
        TabLayoutMediator(binding.tabLayout,binding.viewpager){ tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Trips"
                    tab.icon = ResourcesCompat.getDrawable(resources,R.drawable.trips_tablayout_icon,null)
                }
                1 -> {
                    tab.text = "Booksmark"
                    tab.icon = ResourcesCompat.getDrawable(resources,R.drawable.bookmark_tablayout_icon,null)
                }
            }
        }.attach()

        return binding.root
    }

}