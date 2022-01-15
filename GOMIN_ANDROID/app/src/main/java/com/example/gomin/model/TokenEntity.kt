package com.example.gomin.model

import com.google.gson.annotations.SerializedName

data class TokenEntity(
    @SerializedName("refreshtoken") val refreshToken: String,
    @SerializedName("accesstoken") val accessToken: String
)