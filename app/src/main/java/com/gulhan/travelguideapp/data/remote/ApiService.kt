package com.gulhan.travelguideapp.data.remote

import com.gulhan.travelguideapp.domain.model.guidecategory.GuideCategories
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("GuideCategories")
    fun getAllGuideCategories(): Call<GuideCategories>
}