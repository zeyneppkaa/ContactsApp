package com.example.contactsapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getContactsDao(): ContactsDao{
            return RetrofitClient.getClient(BASE_URL).create(ContactsDao::class.java)
        }
    }
}