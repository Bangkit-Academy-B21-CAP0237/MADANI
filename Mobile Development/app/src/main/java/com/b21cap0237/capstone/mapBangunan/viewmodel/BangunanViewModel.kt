package com.b21cap0237.capstone.mapBangunan.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b21cap0237.capstone.api.ApiConfig
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.response.DistrictDataItem
import com.b21cap0237.capstone.response.DistrictResponse
import com.b21cap0237.capstone.response.MapResponse
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BangunanViewModel:ViewModel() {
    val listBangunan = MutableLiveData<ArrayList<Bangunan>>()
    fun setBangunan(){
        val listItems = ArrayList<Bangunan>()
        val db = FirebaseFirestore.getInstance()

        db.collection("bangunan")
            .get()
            .addOnCompleteListener { task ->
                Log.d("bangunan", "Suksess")
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val idBangunan=document["idBangunan"].toString()
                        val namaKelurahan=document["namaKelurahan"].toString()
                        val gambarAfter=document["gambarAfter"].toString()
                        val gambarBefore=document["gambarBefore"].toString()

                        val bangunan=Bangunan(idBangunan,namaKelurahan,gambarAfter,gambarBefore)
                        listItems.add(bangunan)
                    }
                    Log.d("bangunan", listItems.toString())
                    listBangunan.postValue(listItems)
                } else {
                    Log.w(TAG, "bangunan", task.exception)
                }
            }

    }
    fun getBangunan(): LiveData<ArrayList<Bangunan>> {
        return listBangunan
    }

    val listDistrict = MutableLiveData<List<DistrictDataItem>>()
    fun getDistrict(): LiveData<List<DistrictDataItem>> {
        return listDistrict
    }

    fun setDistrict(){
        val client= ApiConfig.getApiService()
        client.getAllDistrict().enqueue(object : Callback<DistrictResponse> {
            override fun onResponse(call: Call<DistrictResponse>, response: Response<DistrictResponse>) {
                if (response.isSuccessful) {
                    Log.e("setDistrict", response.body()?.data.toString())
                    listDistrict.postValue(response.body()?.data as List<DistrictDataItem>?)
                } else {
                    Log.e("setDistrict", "gagal: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DistrictResponse>, t: Throwable) {
                Log.e("setDistrict", "onFailure: ${t.message.toString()}")
            }
        })
    }
    val listBangunanById = MutableLiveData<List<MapResponse>>()
    fun setBangunanById(id:Int){
        val listItems = ArrayList<MapResponse>()
        val client= ApiConfig.getApiService()
        client.getMapById(id).enqueue(object :Callback<MapResponse>{
            override fun onResponse(call: Call<MapResponse>, response: Response<MapResponse>) {
                if (response.isSuccessful) {
                    Log.e("setBangunanById", response.body().toString())
                    val mapResponse=MapResponse(
                        response.body()?.area,
                        "",
                        response.body()?.photo,
                        "",
                        response.body()?.id,
                        response.body()?.status,
                    )
                    listItems.add(mapResponse)
                    listBangunanById.postValue(listItems)
                } else {
                    Log.e("setBangunanById", "gagal: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MapResponse>, t: Throwable) {
                Log.e("setBangunanById", "onFailure: ${t.message.toString()}")
            }
        })
    }
    fun getBangunanById(): LiveData<List<MapResponse>> {
        return listBangunanById
    }


}