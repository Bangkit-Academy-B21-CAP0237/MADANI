package com.b21cap0237.capstone.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DistrictResponse(

	@field:SerializedName("per_page")
	val perPage: Int? = null,

	@field:SerializedName("data")
	val data: List<DistrictDataItem?>? = null,

	@field:SerializedName("last_page")
	val lastPage: Int? = null,

	@field:SerializedName("next_page_url")
	val nextPageUrl: String? = null,

	@field:SerializedName("prev_page_url")
	val prevPageUrl: String? = null,

	@field:SerializedName("first_page_url")
	val firstPageUrl: String? = null,

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("last_page_url")
	val lastPageUrl: String? = null,

	@field:SerializedName("from")
	val from: Int? = null,

	@field:SerializedName("links")
	val links: List<LinksItem?>? = null,

	@field:SerializedName("to")
	val to: Int? = null,

	@field:SerializedName("current_page")
	val currentPage: Int? = null
) : Parcelable

@Parcelize
data class LinksItem(

	@field:SerializedName("active")
	val active: Boolean? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class DistrictDataItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("map_id")
	val mapId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable
