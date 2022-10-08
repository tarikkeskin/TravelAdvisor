package com.gulhan.travelguideapp.presentations.guide.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.CardMightNeedTheseBinding
import com.gulhan.travelguideapp.databinding.CardTopPickBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.squareup.picasso.Picasso

class TopPickCardAdapter (
    var mContext: Context,
    var travelList: List<TravelsItem>,
) : RecyclerView.Adapter<TopPickCardAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: CardTopPickBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CardTopPickBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardTopPickBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_top_pick, parent, false)
        return CardDesignAttachment(binding)
    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val travel = travelList[position]
        val t = holder.binding

        t.tVTopPickTitle.text = travel.title
        t.tVTopPickText.text = travel.description
        Picasso.get().load(travel.images[0].url).into(t.imageView5)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }
}
