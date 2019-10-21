package com.demomvvmapplication.data.network.model

import androidx.lifecycle.LiveData


data class Gif(
    val next: String,
    val results:   List<Result>  ,
    val weburl: String
)