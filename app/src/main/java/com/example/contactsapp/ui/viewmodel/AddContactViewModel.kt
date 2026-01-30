package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(var crepo: ContactsRepository) : ViewModel() {
    fun saveContact(kisi_ad : String, kisi_tel : String){
        CoroutineScope(Dispatchers.Main).launch {
            crepo.saveContact(kisi_ad,kisi_tel)
        }
    }
}