package com.example.minggu11laprakapi.model.forapi

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class RelicMainProperty(
    @SerializedName("name") val name: String?,
    @SerializedName("value") val value: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RelicMainProperty> {
        override fun createFromParcel(parcel: Parcel): RelicMainProperty {
            return RelicMainProperty(parcel)
        }

        override fun newArray(size: Int): Array<RelicMainProperty?> {
            return arrayOfNulls(size)
        }
    }
}
