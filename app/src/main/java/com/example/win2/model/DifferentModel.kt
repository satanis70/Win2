package com.example.win2.model

import com.google.gson.annotations.SerializedName

data class DifferentModel(
    @SerializedName("different")
    val different: List<Termin>
)
