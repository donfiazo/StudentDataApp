package com.eddie.studentdataapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitProvider {

    private val baseURL = "https://ict-yep-backend.herokuapp.com/"

    private val retrofit = Retrofit.Builder().baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val placeHolderAPI = retrofit.create(PlaceHolderAPI::class.java)

}