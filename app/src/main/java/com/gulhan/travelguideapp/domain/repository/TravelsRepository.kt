package com.gulhan.travelguideapp.domain.repository

import com.gulhan.travelguideapp.domain.model.allList.Travels
import retrofit2.Call

interface TravelsRepository {

    fun getAllTravels(): Call<Travels>
}