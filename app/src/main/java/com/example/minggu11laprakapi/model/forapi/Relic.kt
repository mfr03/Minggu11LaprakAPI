package com.example.minggu11laprakapi.model.forapi

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Relic(
    @SerializedName("name") val name: String?,
    @SerializedName("icon") val icon: String?,
    @SerializedName("main_property") val mainProperty: RelicMainProperty?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(RelicMainProperty::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(icon)
        parcel.writeParcelable(mainProperty, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Relic> {
        override fun createFromParcel(parcel: Parcel): Relic {
            return Relic(parcel)
        }

        override fun newArray(size: Int): Array<Relic?> {
            return arrayOfNulls(size)
        }
    }
}

