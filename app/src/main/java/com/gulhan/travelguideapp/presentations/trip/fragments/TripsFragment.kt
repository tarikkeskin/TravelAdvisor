package com.gulhan.travelguideapp.presentations.trip.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentTripsBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.gulhan.travelguideapp.presentations.trip.TripFragmentViewModel
import com.gulhan.travelguideapp.presentations.trip.adapter.TripsCardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripsFragment : Fragment() {

    private lateinit var binding: FragmentTripsBinding
    private lateinit var adapter: TripsCardAdapter
    private val viewModel by viewModels<TripFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trips, container, false)

        val list: MutableList<TravelsItem> = ArrayList()
        viewModel.getAllTravels().observe(viewLifecycleOwner) {
            it.forEach { trip ->
                if (!trip.isBookmark) {
                    list.add(trip)
                }

                adapter = TripsCardAdapter(requireContext(), list)
                binding.rVTrips.adapter = adapter
            }
        }



        return binding.root
    }

}