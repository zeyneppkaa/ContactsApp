package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.repo.ContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddContactViewModel : ViewModel() {
    var crepo = ContactsRepository()
    fun saveContact(kisi_ad : String, kisi_tel : String){
        CoroutineScope(Dispatchers.Main).launch {
            crepo.saveContact(kisi_ad,kisi_tel)
        }
    }
}