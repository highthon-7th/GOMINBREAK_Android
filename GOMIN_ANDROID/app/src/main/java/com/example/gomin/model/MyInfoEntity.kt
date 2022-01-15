package com.example.gomin.model

import com.google.gson.annotations.SerializedName

data class MyInfoEntity(
    val name: String,
    @SerializedName("comment_count") val commentCount: Int,
    @SerializedName("heart_count") val heartCount: Int,
    val school: String
)
