package com.gulhan.travelguideapp.presentations.trip.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.CardTripBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.gulhan.travelguideapp.presentations.trip.TripFragmentDirections
import com.squareup.picasso.Picasso

class TripsCardAdapter(
    var mContext: Context,
    var travelList: List<TravelsItem>,
) : RecyclerView.Adapter<TripsCardAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: CardTripBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CardTripBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardTripBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_trip, parent, false)
        return CardDesignAttachment(binding)
    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val travel = travelList[position]
        val t = holder.binding

        t.tVCityTrips.text = travel.city
        Picasso.get().load(travel.images[0].url).into(t.imageViewTrips)

        t.cVTrips.setOnClickListener {
            val navigate = TripFragmentDirections.tripToDetail(travel)
            Navigation.findNavController(it).navigate(navigate)
        }

    }

    override fun getItemCount(): Int {
        return travelList.size
    }
}