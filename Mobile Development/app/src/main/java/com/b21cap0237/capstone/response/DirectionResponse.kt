package com.b21cap0237.capstone.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DirectionResponse(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("map_id")
	val mapId: Int? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable
