package com.example.summery8.data

import android.media.Image
import retrofit2.http.GET

interface ApiService {
    @GET("v3/0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getImages(): List<Image>
}