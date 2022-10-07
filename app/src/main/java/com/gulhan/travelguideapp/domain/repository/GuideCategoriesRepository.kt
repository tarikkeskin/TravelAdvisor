package com.gulhan.travelguideapp.domain.repository

import com.gulhan.travelguideapp.domain.model.guidecategory.GuideCategories
import retrofit2.Call

interface GuideCategoriesRepository {

    fun getAllGuideCategories(): Call<GuideCategories>
}