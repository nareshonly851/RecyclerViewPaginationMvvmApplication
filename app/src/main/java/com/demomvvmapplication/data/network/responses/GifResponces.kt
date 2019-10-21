package com.demomvvmapplication.data.network.responses

import com.demomvvmapplication.data.network.model.Result
import com.demomvvmapplication.data.network.model.User

data class GifResponces(

    val weburl: String?,
    val results: List<Result>?
)