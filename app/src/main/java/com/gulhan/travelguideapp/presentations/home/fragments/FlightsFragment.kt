package com.gulhan.travelguideapp.presentations.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentAllBinding
import com.gulhan.travelguideapp.databinding.FragmentFlightsBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.gulhan.travelguideapp.presentations.home.HomeFragmentViewModel
import com.gulhan.travelguideapp.presentations.home.adapter.HomeCardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlightsFragment : Fragment() {

    private lateinit var binding: FragmentFlightsBinding
    private lateinit var adapter: HomeCardAdapter
    private val travelViewModel by viewModels<HomeFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_flights, container, false)

        binding.rvFlights.setHasFixedSize(true)
        binding.rvFlights.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val list: MutableList<TravelsItem> = ArrayList()
        travelViewModel.getAllTravels().observe(viewLifecycleOwner) {
            it.forEach{ flight ->
                if(flight.category == "flight"){
                    list.add(flight)
                }
            }
            adapter = HomeCardAdapter(requireContext(),list)
            binding.rvFlights.adapter = adapter
        }
        return binding.root
    }

}