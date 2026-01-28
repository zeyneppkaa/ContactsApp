package com.example.contactsapp.data.repo

import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.entity.Kisiler

class ContactsRepository {
    var cds = ContactsDataSource()
    suspend fun saveContact(kisi_ad : String, kisi_tel : String) = cds.saveContact(kisi_ad, kisi_tel)
    suspend fun updateContact(kisi_id : Int, kisi_ad : String, kisi_tel : String) = cds.updateContact(kisi_id, kisi_ad, kisi_tel)
    suspend fun delete(kisi_id : Int) = cds.delete(kisi_id)
    suspend fun loadContacts() : List<Kisiler> = cds.loadContacts()
    suspend fun search(searchingWord : String): List<Kisiler> = cds.search(searchingWord)
}