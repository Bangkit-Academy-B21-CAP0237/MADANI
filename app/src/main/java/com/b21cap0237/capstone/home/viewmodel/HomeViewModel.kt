package com.b21cap0237.capstone.home.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b21cap0237.capstone.home.model.Notif
import com.b21cap0237.capstone.mapBangunan.model.Bangunan
import com.google.firebase.firestore.FirebaseFirestore

class HomeViewModel: ViewModel() {
    val listNotif = MutableLiveData<ArrayList<Notif>>()
    fun setNotif(){
        val listItems = ArrayList<Notif>()
        val db = FirebaseFirestore.getInstance()

        db.collection("notif")
            .get()
            .addOnCompleteListener { task ->
                Log.d("notif", "Suksess")
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val id=document["id"].toString()
                        val title=document["title"].toString()
                        val imgUrl=document["imgUrl"].toString()
                        val dateNotif=document["dateNotif"].toString()
                        val locationNotif=document["locationNotif"].toString()
                        val kontent=document["konten"].toString()
                        val notif=Notif(
                            id,
                            title,
                            imgUrl,
                            dateNotif,
                            locationNotif,
                            kontent)
                        listItems.add(notif)
                    }
                    Log.d("notif", listItems.toString())
                    listNotif.postValue(listItems)
                } else {
                    Log.w(ContentValues.TAG, "notif", task.exception)
                }
            }

    }
    fun getNotif(): LiveData<ArrayList<Notif>> {
        return listNotif
    }
}