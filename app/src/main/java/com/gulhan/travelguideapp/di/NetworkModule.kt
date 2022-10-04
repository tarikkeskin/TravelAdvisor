package com.gulhan.travelguideapp.di

import com.gulhan.travelguideapp.data.remote.ApiService
import com.gulhan.travelguideapp.data.remote.repository.GuideCategoryRepositoryImp
import com.gulhan.travelguideapp.domain.repository.GuideCategoriesRepository
import com.gulhan.travelguideapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAllGuideCategories(apiService: ApiService): GuideCategoriesRepository{
        return GuideCategoryRepositoryImp(apiService)
    }
}