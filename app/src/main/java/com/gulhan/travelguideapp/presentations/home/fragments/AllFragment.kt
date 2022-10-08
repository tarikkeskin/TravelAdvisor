package com.gulhan.travelguideapp.presentations.home.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentAllBinding
import com.gulhan.travelguideapp.databinding.HomeCardviewBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.gulhan.travelguideapp.domain.model.guidecategory.GuideCategoriesItem
import com.gulhan.travelguideapp.presentations.guide.GuideViewModel
import com.gulhan.travelguideapp.presentations.guide.adapter.GuideCategoryAdapter
import com.gulhan.travelguideapp.presentations.home.HomeFragmentViewModel
import com.gulhan.travelguideapp.presentations.home.adapter.HomeCardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllFragment : Fragment() {

    private lateinit var binding: FragmentAllBinding
    private lateinit var travelList: List<TravelsItem>
    private lateinit var adapter: HomeCardAdapter
    private val travelViewModel by viewModels<HomeFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_all, container, false)

        binding.rvHome.setHasFixedSize(true)

        travelList = ArrayList()
        travelViewModel.getAllTravels().observe(viewLifecycleOwner) {
            travelList = it
            adapter = HomeCardAdapter(requireContext(),travelList)
            binding.rvHome.adapter = adapter
        }

        return binding.root
    }

}