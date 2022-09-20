package com.example.win2.model


import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("termins")
    val termins: List<Termin>
)