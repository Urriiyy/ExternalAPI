package com.example.externalapi

import com.example.externalapi.models.PostResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostRestApi {
    @GET("posts/{id}")
    fun getById(@Path ("id") id: Int): Call<PostResponse>

    @GET("posts")
    fun getAll(): Call<List<PostResponse>>

    @POST("post")
    fun incert(@Body postResponse: PostResponse): Call<PostResponse>
}