package com.gulhan.travelguideapp.presentations.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentSearchBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.gulhan.travelguideapp.presentations.search.adapter.NearbyAttractionCardAdapter
import com.gulhan.travelguideapp.presentations.search.adapter.TopDestinationCardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    private lateinit var adapter: TopDestinationCardAdapter
    private lateinit var adapter2: NearbyAttractionCardAdapter
    private lateinit var adapterSearch: NearbyAttractionCardAdapter
    private val travelViewModel by viewModels<SearchFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false)


        val listTop: MutableList<TravelsItem> = ArrayList()
        val listNearby: MutableList<TravelsItem> = ArrayList()
        travelViewModel.getAllTravels().observe(viewLifecycleOwner){
            it.forEach{ trip ->
                if(trip.category == "topdestination"){
                    listTop.add(trip)
                }
                if(trip.category == "nearby"){
                    listNearby.add(trip)
                }
            }
            adapter = TopDestinationCardAdapter(requireContext(),listTop)
            adapter2 = NearbyAttractionCardAdapter(requireContext(),listNearby)
            binding.rvTopDestinations.adapter = adapter
            binding.rVNearby.adapter = adapter2
        }

        //Search
        val listAll: MutableList<TravelsItem> = ArrayList()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                travelViewModel.getAllTravels().observe(viewLifecycleOwner){
                    it.forEach{ trip ->
                        if(trip.city.contains(p0!!,true)){
                            listAll.add(trip)
                        }
                    }
                    binding.cLNotSearched.visibility = View.GONE
                    binding.cLSearched.visibility = View.VISIBLE
                    adapterSearch = NearbyAttractionCardAdapter(requireContext(),listAll)
                    binding.rVSearched.adapter = adapterSearch
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })


        return binding.root
    }

}