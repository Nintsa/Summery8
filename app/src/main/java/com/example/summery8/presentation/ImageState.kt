package com.example.summery8.presentation

import com.example.summery8.domain.Image

data class ImageState(
    val success: List<Image>? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
)