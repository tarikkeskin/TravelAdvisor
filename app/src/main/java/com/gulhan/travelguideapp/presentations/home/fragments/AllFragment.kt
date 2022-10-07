package com.gulhan.travelguideapp.presentations.home.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.presentations.guide.GuideViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllFragment : Fragment() {

    private val travelViewModel by viewModels<AllFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        travelViewModel.getAllTravels().observe(viewLifecycleOwner) {
            Log.e("Debug",it.toString())
        }

        return inflater.inflate(R.layout.fragment_all, container, false)
    }

}