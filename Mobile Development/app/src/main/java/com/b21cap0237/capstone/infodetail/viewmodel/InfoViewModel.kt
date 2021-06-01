package com.b21cap0237.capstone.infodetail.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b21cap0237.capstone.infodetail.model.InfoDetail
import com.b21cap0237.capstone.kondisiLapangan.model.Kondisi
import com.b21cap0237.capstone.splashscreen.Splash
import com.google.firebase.firestore.FirebaseFirestore

class InfoViewModel:ViewModel() {
    val listInfoDetail = MutableLiveData<ArrayList<InfoDetail>>()
    val listSplash = MutableLiveData<ArrayList<Splash>>()
    fun setInfoDetail(){
        val listItems = ArrayList<InfoDetail>()
        val db = FirebaseFirestore.getInstance()

        db.collection("infoaplikasi")
            .get()
            .addOnCompleteListener { task ->
                Log.d("InfoDetail", "Suksess")
                Log.d("InfoDetail", task.result.toString())
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val gambarAplikasi=document["gambaraplikasi"].toString()
                        val judulAplikasi=document["judulaplikasi"].toString()
                        val tentangAplikasi=document["tentangaplikasi"].toString()

                        val kondisi= InfoDetail(
                            gambarAplikasi,
                            judulAplikasi,
                            tentangAplikasi,
                            )
                        listItems.add(kondisi)
                    }
                    Log.d("InfoDetail", listItems.toString())
                    listInfoDetail.postValue(listItems)
                } else {
                    Log.w(ContentValues.TAG, "InfoDetail", task.exception)
                }
            }

    }

    fun setSplash(){
        val listItems = ArrayList<Splash>()
        val db = FirebaseFirestore.getInstance()

        db.collection("splashscreen")
            .get()
            .addOnCompleteListener { task ->
                Log.d("Splash", "Suksess")
                Log.d("Splash", task.result.toString())
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val background=document["background"].toString()
                        val kondisi= Splash(
                            background
                        )
                        listItems.add(kondisi)
                    }
                    Log.d("Splash", listItems.toString())
                    listSplash.postValue(listItems)
                } else {
                    Log.w(ContentValues.TAG, "Splash", task.exception)
                }
            }

    }
    fun getKondisi(): LiveData<ArrayList<InfoDetail>> {
        return listInfoDetail
    }
    fun getSplash(): LiveData<ArrayList<Splash>> {
        return listSplash
    }
}