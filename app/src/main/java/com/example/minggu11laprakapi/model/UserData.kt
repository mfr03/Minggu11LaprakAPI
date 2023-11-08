package com.example.minggu11laprakapi.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("player") val player : Player,
    @SerializedName("characters") val characters : List<Characters>,
//    @SerializedName("PlayerSpaceInfo") val playerSpaceInfo : PlayerSpaceInfo
    )
