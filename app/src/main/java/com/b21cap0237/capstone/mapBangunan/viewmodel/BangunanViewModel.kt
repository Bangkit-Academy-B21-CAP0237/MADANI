package com.b21cap0237.capstone.mapBangunan.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.google.firebase.firestore.FirebaseFirestore


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



}