package com.example.mynewgamesapp.data.model.games


import com.google.gson.annotations.SerializedName

data class ScreenshotModel(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image")
    val image: String? = ""
)