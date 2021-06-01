package com.b21cap0237.capstone.infodetail.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoDetail(
    val gambarAplikasi:String,
    val judulAplikasi:String,
    val tentangAplikasi:String
):Parcelable
