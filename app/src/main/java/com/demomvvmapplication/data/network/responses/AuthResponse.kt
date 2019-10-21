package com.mvvmdemo.data.network.responses

import com.demomvvmapplication.data.network.model.User


data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)
