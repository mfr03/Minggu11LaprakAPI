package com.example.minggu11laprakapi.retrofit


import com.example.minggu11laprakapi.model.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    fun getPlayerData(@Url url: String): Call<UserData>
}