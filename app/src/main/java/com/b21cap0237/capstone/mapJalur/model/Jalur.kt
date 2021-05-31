package com.b21cap0237.capstone.mapJalur.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Jalur(
    val idJalur: String,
    val namaKelurahan:String,
    val gambarAfter:String,
    val gambarBefore:String
):Parcelable
