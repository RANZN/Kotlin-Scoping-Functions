package com.ranzan.kotlinscopingfunctions

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("users/{postId}")
    fun getData(@Path("postId") id: Int):Call<ResponseModel>
}