package com.demomvvmapplication.gif

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvmdemo.data.repositories.GifRepository




@Suppress("UNCHECKED_CAST")
class GifViewModelFactory(private val  repository: GifRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GifViewModel(repository) as T
    }
}