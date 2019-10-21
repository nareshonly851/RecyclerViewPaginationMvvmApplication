package com.demomvvmapplication.auth

import com.demomvvmapplication.data.network.model.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure()

}