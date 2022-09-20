package com.example.win2.model

import com.google.gson.annotations.SerializedName

data class TypesModel (
    @SerializedName("typesofbets")
    val typesofbets: List<Termin>
)