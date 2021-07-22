package com.eddie.studentdataapp.models

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("`class`")
    val `class`: String,
    val name: String,
    val seat: String
)