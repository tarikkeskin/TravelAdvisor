package com.gulhan.travelguideapp.data.remote.repository

import com.gulhan.travelguideapp.data.remote.ApiService
import com.gulhan.travelguideapp.domain.model.guidecategory.GuideCategories
import com.gulhan.travelguideapp.domain.repository.GuideCategoriesRepository
import retrofit2.Call

class GuideCategoryRepositoryImp(
    private  val apiService: ApiService
    ) : GuideCategoriesRepository {
    override fun getAllGuideCategories(): Call<GuideCategories> {
        return apiService.getAllGuideCategories()
    }

}