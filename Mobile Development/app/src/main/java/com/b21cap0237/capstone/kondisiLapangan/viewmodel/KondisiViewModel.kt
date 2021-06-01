package com.b21cap0237.capstone.kondisiLapangan.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b21cap0237.capstone.home.model.Notif
import com.b21cap0237.capstone.kondisiLapangan.model.Kondisi
import com.google.firebase.firestore.FirebaseFirestore

class KondisiViewModel:ViewModel() {
    val listKondisi = MutableLiveData<ArrayList<Kondisi>>()
    fun setKondisi(){
        val listItems = ArrayList<Kondisi>()
        val db = FirebaseFirestore.getInstance()

        db.collection("kondisilapangan")
            .get()
            .addOnCompleteListener { task ->
                Log.d("Kondisi", "Suksess")
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val kondisiId=document["kondisiId"].toString()
                        val kondisiJudul=document["kondisiJudul"].toString()
                        val kondisiLokasi=document["KondisiLokasi"].toString()
                        val kondisiKonten=document["kondisiKonten"].toString()
                        val kondisiDate=document["kondisiDate"].toString()
                        val kondisiGambar=document["kondisiGambar"].toString()
                        val kondisi= Kondisi(
                            kondisiId,
                            kondisiJudul,
                            kondisiLokasi,
                            kondisiKonten,
                            kondisiDate,
                            kondisiGambar)
                        listItems.add(kondisi)
                    }
                    Log.d("Kondisi", listItems.toString())
                    listKondisi.postValue(listItems)
                } else {
                    Log.w(ContentValues.TAG, "Kondisi", task.exception)
                }
            }

    }
    fun getKondisi(): LiveData<ArrayList<Kondisi>> {
        return listKondisi
    }
}