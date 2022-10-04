package com.gulhan.travelguideapp.presentations.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnAttach
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentHomeBinding
import com.gulhan.travelguideapp.presentations.trip.ViewPagerAdapterTrip


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        val adapter = ViewPagerAdapterHome(parentFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = adapter
        binding.viewpagerHome.doOnAttach {
            binding.viewpagerHome.setCurrentItem(0, true)
        }
        binding.viewpagerHome.isUserInputEnabled = false // this is for
        TabLayoutMediator(binding.tablayoutHome,binding.viewpagerHome){ tab, position ->
            val tabTitles = ArrayList<String>()
            tabTitles.add("All")
            tabTitles.add("Flights")
            tabTitles.add("Hotels")
            tabTitles.add("Transportations")
            tab.text = tabTitles[position]
        }.attach()



        return binding.root
    }

}