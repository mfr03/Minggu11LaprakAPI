package com.example.minggu11laprakapi.model.forapi

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class LightCone(
    @SerializedName("name") val name : String?,
    @SerializedName("rarity") val rarity : Int,
    @SerializedName("rank") val rank : Int,
    @SerializedName("level") val level : Int,
    @SerializedName("icon") val icon : String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(rarity)
        parcel.writeInt(rank)
        parcel.writeInt(level)
        parcel.writeString(icon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LightCone> {
        override fun createFromParcel(parcel: Parcel): LightCone {
            return LightCone(parcel)
        }

        override fun newArray(size: Int): Array<LightCone?> {
            return arrayOfNulls(size)
        }
    }
}
