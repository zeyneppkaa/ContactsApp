package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactDetailViewModel @Inject constructor(var crepo: ContactsRepository) : ViewModel() {
    fun updateContact(kisi_id : Int, kisi_ad : String, kisi_tel : String) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.updateContact(kisi_id, kisi_ad, kisi_tel)
        }
    }
}