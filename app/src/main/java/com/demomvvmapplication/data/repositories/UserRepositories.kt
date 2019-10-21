package com.mvvmdemo.data.repositories


import com.demomvvmapplication.data.network.MyApi
import com.demomvvmapplication.data.network.SafeApiRequest
import com.mvvmdemo.data.network.responses.AuthResponse


class UserRepository(private val api: MyApi) : SafeApiRequest() {


    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }


}







