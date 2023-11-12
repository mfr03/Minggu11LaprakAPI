package com.example.minggu11laprakapi.model.forapi

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Icons(
    @SerializedName("icon") val icon : String?,
    @SerializedName("unlock") val unlock: Boolean,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(icon)
        parcel.writeByte(if (unlock) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Icons> {
        override fun createFromParcel(parcel: Parcel): Icons {
            return Icons(parcel)
        }

        override fun newArray(size: Int): Array<Icons?> {
            return arrayOfNulls(size)
        }
    }
}
