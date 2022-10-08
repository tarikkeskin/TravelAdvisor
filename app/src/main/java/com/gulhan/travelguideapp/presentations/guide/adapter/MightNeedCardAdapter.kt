package com.gulhan.travelguideapp.presentations.guide.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.CardMightNeedTheseBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.squareup.picasso.Picasso

class MightNeedCardAdapter(
    var mContext: Context,
    var travelList: List<TravelsItem>,
) : RecyclerView.Adapter<MightNeedCardAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: CardMightNeedTheseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CardMightNeedTheseBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardMightNeedTheseBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_might_need_these, parent, false)
        return CardDesignAttachment(binding)
    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val travel = travelList[position]
        val t = holder.binding

        t.tVMightNeedThese.text = travel.title
        Picasso.get().load(travel.images[0].url).into(t.imageView8)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }
}