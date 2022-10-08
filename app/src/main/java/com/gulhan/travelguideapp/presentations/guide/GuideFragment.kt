package com.gulhan.travelguideapp.presentations.guide

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentGuideBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.gulhan.travelguideapp.domain.model.guidecategory.GuideCategoriesItem
import com.gulhan.travelguideapp.presentations.guide.adapter.GuideCategoryAdapter
import com.gulhan.travelguideapp.presentations.guide.adapter.MightNeedCardAdapter
import com.gulhan.travelguideapp.presentations.guide.adapter.TopPickCardAdapter
import com.gulhan.travelguideapp.presentations.search.SearchFragmentViewModel
import com.gulhan.travelguideapp.presentations.search.adapter.NearbyAttractionCardAdapter
import com.gulhan.travelguideapp.presentations.search.adapter.TopDestinationCardAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding
    private lateinit var categoryList: List<GuideCategoriesItem>
    private lateinit var adapter: GuideCategoryAdapter
    private lateinit var adapter2: MightNeedCardAdapter
    private lateinit var adapter3: TopPickCardAdapter
    private val travelViewModel by viewModels<GuideViewModel>()
    private val guideViewModel by viewModels<GuideViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_guide, container, false)

        binding.rvGuideCategories.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        categoryList = ArrayList()
        guideViewModel.getAllGuideCategories().observe(viewLifecycleOwner, Observer {
            categoryList = it
            adapter = GuideCategoryAdapter(requireContext(), categoryList)
            binding.rvGuideCategories.adapter = adapter
        })

        val list2: MutableList<TravelsItem> = ArrayList()
        val list3: MutableList<TravelsItem> = ArrayList()
        travelViewModel.getAllTravels().observe(viewLifecycleOwner){
            it.forEach{ flight ->
                if(flight.category == "nearby"){
                    list2.add(flight)
                }
                if(flight.category == "toppick"){
                    list3.add(flight)
                }
            }
            adapter2 = MightNeedCardAdapter(requireContext(),list2)
            binding.rvGuideNeedThese.adapter = adapter2

            adapter3 = TopPickCardAdapter(requireContext(),list3)
            binding.rVTopPick.adapter = adapter3
        }



        return binding.root
    }

}