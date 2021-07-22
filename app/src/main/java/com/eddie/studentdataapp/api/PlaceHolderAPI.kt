package com.eddie.studentdataapp.api

import androidx.lifecycle.MutableLiveData
import com.eddie.studentdataapp.models.Item
import com.eddie.studentdataapp.models.Student
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlaceHolderAPI {
    @GET("Items")
    suspend fun getItems(): List<Item>

    @POST("Students")
    suspend fun addStudent (@Body newStudent: Student): List<Student>
}