package com.b21cap0237.capstone.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MapResponse(
	val area: String? = null,
	val updatedAt: String? = null,
	val photo: String? = null,
	val createdAt: String? = null,
	val id: Int? = null,
	val status: String? = null
) : Parcelable
