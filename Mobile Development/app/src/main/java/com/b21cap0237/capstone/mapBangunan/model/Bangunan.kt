package com.b21cap0237.capstone.mapBangunan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Bangunan(
    val idBangunan: String,
    val namaKelurahan:String,
    val gambarAfter:String,
    val gambarBefore:String
):Parcelable
