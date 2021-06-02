package com.b21cap0237.capstone.mapJalur.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b21cap0237.capstone.api.ApiConfig
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapJalur.model.Jalur
import com.b21cap0237.capstone.response.DirectionResponse
import com.b21cap0237.capstone.response.DistrictDataItem
import com.b21cap0237.capstone.response.DistrictResponse
import com.b21cap0237.capstone.response.MapResponse
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JalurViewModel:ViewModel() {
    val listJalur = MutableLiveData<ArrayList<Jalur>>()
    fun setJalur(){
        val listItems = ArrayList<Jalur>()
        val db = FirebaseFirestore.getInstance()

        db.collection("Jalur")
            .get()
            .addOnCompleteListener { task ->
                Log.d("Jalur", "Suksess")
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val idJalur=document["idJalur"].toString()
                        val namaKelurahan=document["namaKelurahan"].toString()
                        val gambarAfter=document["gambarAfter"].toString()
                        val gambarBefore=document["gambarBefore"].toString()

                        val jalur= Jalur(idJalur,namaKelurahan,gambarAfter,gambarBefore)
                        listItems.add(jalur)
                    }
                    Log.d("Jalur", listItems.toString())
                    listJalur.postValue(listItems)
                } else {
                    Log.w(ContentValues.TAG, "Jalur", task.exception)
                }
            }

    }
    fun getJalur(): LiveData<ArrayList<Jalur>> {
        return listJalur
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

    val listJalurById = MutableLiveData<List<DirectionResponse>>()
    fun setJalurById(id:Int){
        val listItems = ArrayList<DirectionResponse>()
        val client= ApiConfig.getApiService()
        client.getDirectionById(id).enqueue(object :Callback<DirectionResponse>{
            override fun onResponse(call: Call<DirectionResponse>, response: Response<DirectionResponse>) {
                if (response.isSuccessful) {
                    Log.e("setJalurById", response.body().toString())
                    val directionResponse= DirectionResponse(
                        "",
                        response.body()?.mapId,
                        response.body()?.photo,
                        "",
                        response.body()?.id,
                        response.body()?.status
                    )
                    listItems.add(directionResponse)
                    listJalurById.postValue(listItems)
                } else {
                    Log.e("setJalurById", "gagal: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DirectionResponse>, t: Throwable) {
                Log.e("setJalurById", "onFailure: ${t.message.toString()}")
            }
        })
    }
    fun getJalurById(): LiveData<List<DirectionResponse>> {
        return listJalurById
    }
}