package com.example.minggu11laprakapi.model

import com.google.gson.annotations.SerializedName

data class LightCone(
    @SerializedName("name") val name : String,
    @SerializedName("rarity") val rarity : Int,
    @SerializedName("rank") val rank : Int,
    @SerializedName("level") val level : Int,
    @SerializedName("icon") val icon : String,
)
