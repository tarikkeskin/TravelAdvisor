package com.gulhan.travelguideapp.presentations.trip

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gulhan.travelguideapp.domain.model.allList.Travels
import com.gulhan.travelguideapp.domain.usecase.TravelsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TripFragmentViewModel @Inject constructor(
    private val travelsUseCase: TravelsUseCase,
) : ViewModel() {
    fun getAllTravels(): LiveData<Travels> {
        travelsUseCase.apply {
            getAllTravels()
            return allTravels
        }
    }
}