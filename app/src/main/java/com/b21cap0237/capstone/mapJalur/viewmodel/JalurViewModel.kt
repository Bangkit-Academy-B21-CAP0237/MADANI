package com.b21cap0237.capstone.mapJalur.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.b21cap0237.capstone.mapJalur.model.Jalur
import com.google.firebase.firestore.FirebaseFirestore

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
}