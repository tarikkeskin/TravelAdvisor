package com.gulhan.travelguideapp.presentations.search.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.CardTopdestinationBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.squareup.picasso.Picasso

class TopDestinationCardAdapter(
    var mContext: Context,
    var travelList: List<TravelsItem>,
) : RecyclerView.Adapter<TopDestinationCardAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: CardTopdestinationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CardTopdestinationBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardTopdestinationBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_topdestination, parent, false)
        return CardDesignAttachment(binding)
    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val travel = travelList[position]
        val t = holder.binding

        t.tVCityTopDestination.text = travel.city
        t.tVCountryTopDestination.text = travel.country
        Picasso.get().load(travel.images[0].url).into(t.imageView3)


    }

    override fun getItemCount(): Int {
        return travelList.size
    }
}