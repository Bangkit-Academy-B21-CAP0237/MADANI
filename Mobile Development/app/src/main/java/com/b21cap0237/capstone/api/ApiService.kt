package com.b21cap0237.capstone.api

import com.b21cap0237.capstone.response.DirectionResponse
import com.b21cap0237.capstone.response.DistrictDataItem
import com.b21cap0237.capstone.response.DistrictResponse
import com.b21cap0237.capstone.response.MapResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("api/district")
    fun getAllDistrict(): Call<DistrictResponse>

    @GET("api/map/{map_id}")
    fun getMapById(
        @Path("map_id") mapId:Int,
    ):Call<MapResponse>

    @GET("api/direction/{direction_id}")
    fun getDirectionById(
        @Path("direction_id") directionId:Int,
    ):Call<DirectionResponse>
}