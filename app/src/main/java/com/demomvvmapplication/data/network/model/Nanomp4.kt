package com.demomvvmapplication.data.network.model

data class Nanomp4(
    val dims: List<Int>,
    val duration: Double,
    val preview: String,
    val size: Int,
    val url: String
)