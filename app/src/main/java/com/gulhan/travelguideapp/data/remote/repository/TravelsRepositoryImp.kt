package com.gulhan.travelguideapp.data.remote.repository

import com.gulhan.travelguideapp.data.remote.ApiService
import com.gulhan.travelguideapp.domain.model.allList.Travels
import com.gulhan.travelguideapp.domain.repository.TravelsRepository
import retrofit2.Call

class TravelsRepositoryImp(
    private val apiService: ApiService
) :TravelsRepository{
    override fun getAllTravels(): Call<Travels> {
        return apiService.getAllTravelList()
    }
}