package com.example.minggu11laprakapi.model

import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("name") val name : String,
    @SerializedName("rarity") val rarity : Int,
    @SerializedName("level") val level : Int,
    @SerializedName("rank") val rank : Int,
    @SerializedName("portrait") val portrait : String,
    @SerializedName("path") val path : String,
    @SerializedName("path_icon") val pathIcon : String,
    @SerializedName("element") val element : String,
    @SerializedName("element_icon") val elementIcon : String,
    @SerializedName("light_cone") val lightCone: LightCone,
)
