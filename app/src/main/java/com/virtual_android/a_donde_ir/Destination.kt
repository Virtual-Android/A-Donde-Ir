package com.virtual_android.a_donde_ir

import android.os.Parcel
import android.os.Parcelable

data class Destination(
    val imageUrl: String,
    val name: String,
    val description: String,
    val rate: Int?,
    val temperature: String,
    val ubicacion: String,
    val latitude: String,
    val longitude: String

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imageUrl)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeValue(rate)
        parcel.writeString(temperature)
        parcel.writeString(ubicacion)
        parcel.writeString(latitude)
        parcel.writeString(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Destination> {
        override fun createFromParcel(parcel: Parcel): Destination {
            return Destination(parcel)
        }

        override fun newArray(size: Int): Array<Destination?> {
            return arrayOfNulls(size)
        }
    }
}
