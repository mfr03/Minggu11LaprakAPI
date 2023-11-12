package com.example.minggu11laprakapi.model.forapi

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Relics(
    @SerializedName("1") val headPiece: Relic?,
    @SerializedName("2") val glovePiece: Relic?,
    @SerializedName("3") val chestPiece: Relic?,
    @SerializedName("4") val bootsPiece: Relic?,
    @SerializedName("5") val planarPiece: Relic?,
    @SerializedName("6") val ropePiece: Relic?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Relic::class.java.classLoader),
        parcel.readParcelable(Relic::class.java.classLoader),
        parcel.readParcelable(Relic::class.java.classLoader),
        parcel.readParcelable(Relic::class.java.classLoader),
        parcel.readParcelable(Relic::class.java.classLoader),
        parcel.readParcelable(Relic::class.java.classLoader),
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(headPiece, flags)
        parcel.writeParcelable(glovePiece, flags)
        parcel.writeParcelable(chestPiece, flags)
        parcel.writeParcelable(bootsPiece, flags)
        parcel.writeParcelable(planarPiece, flags)
        parcel.writeParcelable(ropePiece, flags)
    }

    companion object CREATOR : Parcelable.Creator<Relics> {
        override fun createFromParcel(parcel: Parcel): Relics {
            return Relics(parcel)
        }

        override fun newArray(size: Int): Array<Relics?> {
            return arrayOfNulls(size)
        }
    }
}
