package com.gulhan.travelguideapp.presentations.guide.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gulhan.travelguideapp.R
import com.gulhan.travelguideapp.databinding.GuideCategoryCardviewBinding
import com.gulhan.travelguideapp.domain.model.guidecategory.GuideCategoriesItem

class GuideCategoryAdapter(
    var mContext: Context,
    var categoryList: List<GuideCategoriesItem>,
) : RecyclerView.Adapter<GuideCategoryAdapter.CardDesignAttachment>() {

    inner class CardDesignAttachment(binding: GuideCategoryCardviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: GuideCategoryCardviewBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignAttachment {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding:GuideCategoryCardviewBinding = DataBindingUtil.inflate(layoutInflater,R.layout.guide_category_cardview, parent, false)
        return CardDesignAttachment(binding)

    }

    override fun onBindViewHolder(holder: CardDesignAttachment, position: Int) {
        val category = categoryList.get(position)
        val t = holder.binding

        t.tVCategory.text = category.title
        t.iVCategory.setImageResource(mContext.resources.getIdentifier(category.icon,"drawable",mContext.packageName))

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}