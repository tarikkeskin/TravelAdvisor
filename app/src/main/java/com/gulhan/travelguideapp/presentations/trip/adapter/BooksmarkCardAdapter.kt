package com.gulhan.travelguideapp.presentations.trip.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.CardBooksmarkBinding
import com.gulhan.travelguideapp.domain.model.allList.TravelsItem
import com.squareup.picasso.Picasso

class BooksmarkCardAdapter(
    var mContext: Context,
    var travelList: List<TravelsItem>,
) : RecyclerView.Adapter<BooksmarkCardAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: CardBooksmarkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CardBooksmarkBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardBooksmarkBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_booksmark, parent, false)
        return CardDesignAttachment(binding)
    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val travel = travelList[position]
        val t = holder.binding

        t.tVCityBooksmark.text = travel.city
        Picasso.get().load(travel.images[0].url).into(t.imageViewBooksmark)
        Log.e("Debug-",travel.images[0].url)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }
}