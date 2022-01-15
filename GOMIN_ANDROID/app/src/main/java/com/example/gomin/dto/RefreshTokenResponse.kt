package com.example.gomin.dto

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(
    @SerializedName("accesstoken") val accessToken: String
)