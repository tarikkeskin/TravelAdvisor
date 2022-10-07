package com.gulhan.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gulhan.travelguideapp.domain.model.guidecategory.GuideCategories
import com.gulhan.travelguideapp.domain.repository.GuideCategoriesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GuideCategoriesUseCase @Inject constructor(
    private val guideCategoriesRepository: GuideCategoriesRepository
) {

    private var _allGuideCategories = MutableLiveData<GuideCategories>()
    val allGuideCategories: LiveData<GuideCategories> = _allGuideCategories

    fun getAllGuideCategories(){
        guideCategoriesRepository.getAllGuideCategories().enqueue(object : Callback<GuideCategories>{
            override fun onResponse(
                call: Call<GuideCategories>,
                response: Response<GuideCategories>,
            ) {
                _allGuideCategories.value = response.body()
            }

            override fun onFailure(call: Call<GuideCategories>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}