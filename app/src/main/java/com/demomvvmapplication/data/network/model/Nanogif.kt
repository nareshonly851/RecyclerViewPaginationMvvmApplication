package com.demomvvmapplication.data.network.model

data class Nanogif(
    val dims: List<Int>,
    val preview: String,
    val size: Int,
    val url: String
)