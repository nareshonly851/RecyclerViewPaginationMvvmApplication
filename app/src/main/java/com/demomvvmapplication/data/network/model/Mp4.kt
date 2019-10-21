package com.demomvvmapplication.data.network.model

data class Mp4(
    val dims: List<Int>,
    val duration: Double,
    val preview: String,
    val size: Int,
    val url: String
)