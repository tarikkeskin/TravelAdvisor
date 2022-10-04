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
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentGuideBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding
    private val guideViewModel by viewModels<GuideViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_guide,container,false)

        guideViewModel.getAllGuideCategories().observe(viewLifecycleOwner, Observer {
            Log.e("Debug",it.toString())
        })
        return binding.root
    }

}