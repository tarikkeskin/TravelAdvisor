package com.gulhan.travelguideapp.presentations.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.HomeCardviewBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.squareup.picasso.Picasso

class HomeCardAdapter(
    var mContext: Context,
    var travelList: List<TravelsItem>,
) : RecyclerView.Adapter<HomeCardAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: HomeCardviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: HomeCardviewBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: HomeCardviewBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.home_cardview, parent, false)
        return CardDesignAttachment(binding)
    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val travel = travelList[position]
        val t = holder.binding

        Picasso.get().load(travel.images[0].url).into(t.iVHomeCard)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }
}