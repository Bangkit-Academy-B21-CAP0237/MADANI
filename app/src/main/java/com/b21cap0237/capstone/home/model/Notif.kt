package com.b21cap0237.capstone.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Notif(
    val id:String,
    val title:String,
    val imgUrl:String,
    val dateNotif:String,
    val locationNotif:String,
    val kontent:String
):Parcelable
