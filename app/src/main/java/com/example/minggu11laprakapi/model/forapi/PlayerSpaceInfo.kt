package com.example.minggu11laprakapi.model.forapi

import com.google.gson.annotations.SerializedName

data class PlayerSpaceInfo(
    @SerializedName("AchievementCount") val achievementCount: Int,
    @SerializedName("AvatarCount") val avatarCount: Int,
)
