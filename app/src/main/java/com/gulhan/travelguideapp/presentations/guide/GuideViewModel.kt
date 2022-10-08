package com.gulhan.travelguideapp.presentations.guide

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gulhan.travelguideapp.domain.model.allList.Travels
import com.gulhan.travelguideapp.domain.model.guidecategory.GuideCategories
import com.gulhan.travelguideapp.domain.usecase.GuideCategoriesUseCase
import com.gulhan.travelguideapp.domain.usecase.TravelsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    private val guideCategoriesUseCase: GuideCategoriesUseCase,
    private val travelsUseCase: TravelsUseCase
):ViewModel(){

    fun getAllGuideCategories(): LiveData<GuideCategories>{
        guideCategoriesUseCase.apply {
            getAllGuideCategories()
            return allGuideCategories
        }
    }

    fun getAllTravels(): LiveData<Travels> {
        travelsUseCase.apply {
            getAllTravels()
            return allTravels
        }
    }
}