package com.gulhan.travelguideapp.presentations.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.CardNearbyBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.squareup.picasso.Picasso

class NearbyAttractionCardAdapter(
    var mContext: Context,
    var travelList: List<TravelsItem>,
) : RecyclerView.Adapter<NearbyAttractionCardAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: CardNearbyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CardNearbyBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardNearbyBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_nearby, parent, false)
        return CardDesignAttachment(binding)
    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val travel = travelList[position]
        val t = holder.binding

        t.tVCityNearby.text = travel.city
        t.tVCountryNearby.text = travel.country
        Picasso.get().load(travel.images[0].url).into(t.imageView7)


    }

    override fun getItemCount(): Int {
        return travelList.size
    }
}