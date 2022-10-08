package com.gulhan.travelguideapp.presentations.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val travel = bundle.tripItem

        Picasso.get().load(travel.images[0].url).into(binding.roundedImageView)
        Picasso.get().load(travel.images[0].url).into(binding.roundedImageViewSmall11)
        Picasso.get().load(travel.images[1].url).into(binding.roundedImageViewSmall12)
        Picasso.get().load(travel.images[2].url).into(binding.roundedImageViewSmall13)
        Picasso.get().load(travel.images[3].url).into(binding.roundedImageViewSmall14)
        binding.tVCityNameDetail.text = travel.city
        binding.tVLocationDetail.text = travel.country
        binding.tVTextDetail.text = travel.description

        binding.cardView.setOnClickListener {
            Picasso.get().load(travel.images[0].url).into(binding.roundedImageView)
        }
        binding.cardView2.setOnClickListener {
            Picasso.get().load(travel.images[1].url).into(binding.roundedImageView)
        }
        binding.cardView3.setOnClickListener {
            Picasso.get().load(travel.images[2].url).into(binding.roundedImageView)
        }
        binding.cardView4.setOnClickListener {
            Picasso.get().load(travel.images[3].url).into(binding.roundedImageView)
        }

        binding.button.setOnClickListener{
            Snackbar.make(it,"Added to the Bookmarks..",Snackbar.LENGTH_SHORT).setBackgroundTint(resources.getColor(R.color.primary_1)).show()
        }


        return binding.root
    }

}