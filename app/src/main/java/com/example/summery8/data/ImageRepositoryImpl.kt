package com.example.summery8.data

import android.media.Image

class ImageRepositoryImpl (private val apiService: ApiService) {
    suspend fun getImages(): List<Image> {
        return apiService.getImages()
    }
}