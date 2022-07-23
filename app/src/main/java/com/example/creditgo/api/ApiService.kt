package com.example.creditgo.api

import com.example.creditgo.model.DataResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users/JakeWharton/repos?per_page=15")
    suspend fun getUsers(@Query("page") page: Int): List<DataResponseItem>

}