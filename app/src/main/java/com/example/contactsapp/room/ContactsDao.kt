package com.example.contactsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contactsapp.data.entity.Kisiler

@Dao
interface ContactsDao {
    @Query("SELECT * FROM kisiler")
    suspend fun loadContacts() : List<Kisiler>

    @Insert
    suspend fun save(contact: Kisiler)

    @Update
    suspend fun update(contact: Kisiler)

    @Delete
    suspend fun delete(contact: Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :searchingWord || '%' ")
    suspend fun search(searchingWord: String) : List<Kisiler>
}