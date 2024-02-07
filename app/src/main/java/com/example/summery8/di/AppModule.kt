package com.example.summery8.di

import android.app.Application
import com.example.summery8.data.ApiService
import com.example.summery8.data.ImageRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(application: Application) {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("your_base_url")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideImageRepository(apiService: ApiService): ImageRepositoryImpl {
        return ImageRepositoryImpl(apiService)
    }
}