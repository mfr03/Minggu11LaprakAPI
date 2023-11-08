package com.example.minggu11laprakapi.model

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("uid") val uid : Int,
    @SerializedName("name") val name : String,
    @SerializedName("level") val level: Int,
    @SerializedName("icon") val icon: String,
    @SerializedName("signature") val signature: String
)
