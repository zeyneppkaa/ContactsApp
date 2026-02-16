package com.example.contactsapp.data.datasource

import com.example.contactsapp.data.entity.Kisiler
import com.example.contactsapp.retrofit.ContactsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource(var cdao: ContactsDao) {
    suspend fun loadContacts() : List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext cdao.loadContacts().kisiler
        }

    suspend fun search(searchingWord : String): List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext cdao.search(searchingWord).kisiler
        }

    suspend fun saveContact(kisi_ad : String, kisi_tel : String) = cdao.save(kisi_ad,kisi_tel)

    suspend fun updateContact(kisi_id : Int, kisi_ad : String, kisi_tel : String) = cdao.update(kisi_id, kisi_ad, kisi_tel)

    suspend fun delete(kisi_id : Int) = cdao.delete(kisi_id)
}