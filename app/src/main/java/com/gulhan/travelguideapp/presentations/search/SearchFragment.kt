package com.gulhan.travelguideapp.presentations.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentSearchBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.gulhan.travelguideapp.presentations.home.HomeFragmentViewModel
import com.gulhan.travelguideapp.presentations.home.adapter.HomeCardAdapter
import com.gulhan.travelguideapp.presentations.search.adapter.NearbyAttractionCardAdapter
import com.gulhan.travelguideapp.presentations.search.adapter.TopDestinationCardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    private lateinit var adapter: TopDestinationCardAdapter
    private lateinit var adapter2: NearbyAttractionCardAdapter
    private val travelViewModel by viewModels<SearchFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false)


        val list: MutableList<TravelsItem> = ArrayList()
        val list2: MutableList<TravelsItem> = ArrayList()
        travelViewModel.getAllTravels().observe(viewLifecycleOwner){
            it.forEach{ flight ->
                if(flight.category == "topdestination"){
                    list.add(flight)
                }
                if(flight.category == "nearby"){
                    list2.add(flight)
                }
            }
            adapter = TopDestinationCardAdapter(requireContext(),list)
            adapter2 = NearbyAttractionCardAdapter(requireContext(),list2)
            binding.rvTopDestinations.adapter = adapter
            binding.rVNearby.adapter = adapter2
        }


        return binding.root
    }

}