package com.example.summery8.presentation

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.summery8.data.ImageRepositoryImpl
import kotlinx.coroutines.launch

class HomeViewModel(private val imageRepository: ImageRepositoryImpl) : ViewModel() {
    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> = _images

    fun fetchImages() {
        viewModelScope.launch {
            try {
                val images = imageRepository.getImages()
                _images.value = images
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
