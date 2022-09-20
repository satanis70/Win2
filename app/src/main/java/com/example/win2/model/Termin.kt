package com.example.win2.model


import com.google.gson.annotations.SerializedName

data class Termin(
    @SerializedName("text")
    val text: String,
    @SerializedName("title")
    val title: String
)