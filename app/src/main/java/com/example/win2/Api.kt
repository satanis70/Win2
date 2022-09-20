package com.example.win2

import com.example.win2.model.DifferentModel
import com.example.win2.model.Model
import com.example.win2.model.TypesModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/win1/termins.json")
    fun getTermens(): Call<Model>

    @GET("/win1/typesofbets.json")
    fun getTypes(): Call<TypesModel>

    @GET("/win1/different.json")
    fun getDifferent():Call<DifferentModel>
}