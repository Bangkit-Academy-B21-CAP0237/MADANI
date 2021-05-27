package com.b21cap0237.capstone.mapBangunan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kerusakan(
    val title:String,
    val urlImg:String,
    val content:String,
    val location:String
):Parcelable
