package com.example.minggu11laprakapi.model.forapi

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("name") val name: String?,
    @SerializedName("rarity") val rarity: Int,
    @SerializedName("level") val level: Int,
    @SerializedName("rank") val rank: Int,
    @SerializedName("portrait") val portrait: String?,
    @SerializedName("path") val path: String?,
    @SerializedName("path_icon") val pathIcon: String?,
    @SerializedName("element") val element: String?,
    @SerializedName("element_icon") val elementIcon: String?,
    @SerializedName("rank_icons") val rankIcons: List<Icons>?,
    @SerializedName("light_cone") val lightCone: LightCone?,
    @SerializedName("relic") val relics: Relics?,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Icons),
        parcel.readParcelable(LightCone::class.java.classLoader),
        parcel.readParcelable(Relics::class.java.classLoader),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(rarity)
        parcel.writeInt(level)
        parcel.writeInt(rank)
        parcel.writeString(portrait)
        parcel.writeString(path)
        parcel.writeString(pathIcon)
        parcel.writeString(element)
        parcel.writeString(elementIcon)
        parcel.writeTypedList(rankIcons)
        parcel.writeParcelable(lightCone, flags)
        parcel.writeParcelable(relics, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Characters> {
        override fun createFromParcel(parcel: Parcel): Characters {
            return Characters(parcel)
        }

        override fun newArray(size: Int): Array<Characters?> {
            return arrayOfNulls(size)
        }
    }

}
