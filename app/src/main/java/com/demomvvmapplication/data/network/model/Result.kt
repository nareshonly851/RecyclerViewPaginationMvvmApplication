package com.demomvvmapplication.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Result(

    @PrimaryKey(autoGenerate = false)
    val id: String,
    //val composite: Any,
    val created: Double,
    val hasaudio: Boolean,
    val itemurl: String,
   // val media: List<Media>,
    val shares: Int,
  //  val tags: List<Any>,
    val title: String,
    val url: String
)