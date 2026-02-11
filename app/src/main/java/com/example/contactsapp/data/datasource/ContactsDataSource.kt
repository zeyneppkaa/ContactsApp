package com.example.contactsapp.data.datasource

import com.example.contactsapp.data.entity.Kisiler
import com.example.contactsapp.room.ContactsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsDataSource(var cdao: ContactsDao) {
    suspend fun loadContacts() : List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext cdao.loadContacts()
        }

    suspend fun search(searchingWord : String): List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext cdao.search(searchingWord)
        }

    suspend fun saveContact(kisi_ad : String, kisi_tel : String){
        val newContact = Kisiler(0, kisi_ad, kisi_tel)
        cdao.save(newContact)
    }

    suspend fun updateContact(kisi_id : Int, kisi_ad : String, kisi_tel : String){
        val updatedContact = Kisiler(kisi_id, kisi_ad, kisi_tel)
        cdao.update(updatedContact)
    }

    suspend fun delete(kisi_id : Int){
        val deletedContact = Kisiler(kisi_id, "", "")
        cdao.delete(deletedContact)
    }
}