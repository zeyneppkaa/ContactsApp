package com.example.contactsapp.data.datasource

import android.util.Log
import com.example.contactsapp.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource {
    suspend fun loadContacts() : List<Kisiler> =
        withContext(Dispatchers.IO){
            val contactsList = ArrayList<Kisiler>()
            val k1 = Kisiler(1, "Ahmet", "1111")
            val k2 = Kisiler(2,"Zeynep","2222")
            val k3 = Kisiler(3,"Beyza","3333")
            contactsList.add(k1)
            contactsList.add(k2)
            contactsList.add(k3)
            return@withContext contactsList
        }

    suspend fun search(searchingWord : String): List<Kisiler> =
        withContext(Dispatchers.IO){
            val contactsList = ArrayList<Kisiler>()
            val k1 = Kisiler(1, "Ahmet", "1111")
            contactsList.add(k1)
            return@withContext contactsList
        }

    suspend fun saveContact(kisi_ad : String, kisi_tel : String){
        Log.e("Save contact", "$kisi_ad - $kisi_tel")
    }

    suspend fun updateContact(kisi_id : Int, kisi_ad : String, kisi_tel : String){
        Log.e("Update contact", "$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun delete(kisi_id : Int){
        Log.e("Delete Contact", kisi_id.toString())
    }
}