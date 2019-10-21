package com.demomvvmapplication.data.network

import com.demomvvmapplication.data.network.model.Gif
import com.demomvvmapplication.data.network.responses.GifResponces
import com.mvvmdemo.data.network.responses.AuthResponse
import retrofit2.Call
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {


    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>


    @GET("/v1/search")
    suspend fun getGif(
        @Query("key") key: String,
        @Query("limit") limit: Int
    ): Response<Gif>






    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .baseUrl("https://api.tenor.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }


}