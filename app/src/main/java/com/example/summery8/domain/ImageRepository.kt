package com.example.summery8.domain

interface ImageRepository {
    suspend fun getImages(): List<Image>
}