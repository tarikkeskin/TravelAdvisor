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
import com.gulhan.travelguideapp.databinding.FragmentTransportationsBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.gulhan.travelguideapp.presentations.home.HomeFragmentViewModel
import com.gulhan.travelguideapp.presentations.home.adapter.HomeCardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransportationsFragment : Fragment() {

    private lateinit var binding: FragmentTransportationsBinding
    private lateinit var adapter: HomeCardAdapter
    private val travelViewModel by viewModels<HomeFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_transportations, container, false)
        binding.rvTransportations.setHasFixedSize(true)
        binding.rvTransportations.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val list: MutableList<TravelsItem> = ArrayList()
        travelViewModel.getAllTravels().observe(viewLifecycleOwner) {
            it.forEach{ flight ->
                if(flight.category == "transportation"){
                    list.add(flight)
                }
            }
            adapter = HomeCardAdapter(requireContext(),list)
            binding.rvTransportations.adapter = adapter
        }
        return binding.root
    }

}