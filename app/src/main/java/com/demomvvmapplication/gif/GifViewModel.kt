package com.demomvvmapplication.gif


import androidx.lifecycle.ViewModel
import com.mvvmdemo.data.repositories.GifRepository

import com.mvvmdemo.util.lazyDeferred


class GifViewModel(repository: GifRepository) : ViewModel() {

    var limit: Int? = 10

    val gif by lazyDeferred {
        limit?.let { repository.getQuotes("9A4PHOJPWO46", it) }
    }

    fun pagging(){
        limit?.plus(10)
    }



}
