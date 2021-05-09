package com.b21cap0237.capstone.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListMenu(
    var title:String,
    var ic: Int
):Parcelable
