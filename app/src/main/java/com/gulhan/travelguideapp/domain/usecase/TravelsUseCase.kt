package com.gulhan.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gulhan.travelguideapp.domain.model.allList.Travels
import com.gulhan.travelguideapp.domain.repository.TravelsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class TravelsUseCase @Inject constructor(
    private val travelsRepository: TravelsRepository
) {

    private var _allTravels = MutableLiveData<Travels>()
    val allTravels: LiveData<Travels> = _allTravels

    fun getAllTravels(){
        travelsRepository.getAllTravels().enqueue(object : Callback<Travels>{
            override fun onResponse(call: Call<Travels>, response: Response<Travels>) {
                _allTravels.value = response.body()
            }

            override fun onFailure(call: Call<Travels>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}