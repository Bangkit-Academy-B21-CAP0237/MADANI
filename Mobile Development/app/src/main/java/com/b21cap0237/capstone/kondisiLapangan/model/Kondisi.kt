package com.b21cap0237.capstone.kondisiLapangan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kondisi(
    val kondisiId:String,
    val kondisiJudul:String,
    val kondisiLokasi:String,
    val kondisiKonten:String,
    val kondisiDate:String,
    val kondisiGambar:String
):Parcelable
