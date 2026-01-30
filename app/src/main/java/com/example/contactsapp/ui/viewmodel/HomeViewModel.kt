package com.example.contactsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactsapp.data.entity.Kisiler
import com.example.contactsapp.data.repo.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(var crepo: ContactsRepository) : ViewModel() {
    var contactsList = MutableLiveData<List<Kisiler>>()

    init{
        loadContacts()
    }

    fun delete(kisi_id : Int) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.delete(kisi_id)
            loadContacts()
        }
    }

    fun loadContacts() {
        CoroutineScope(Dispatchers.Main).launch {
            contactsList.value = crepo.loadContacts()
        }
    }

    fun search(searchingWord : String){
        CoroutineScope(Dispatchers.Main).launch {
            contactsList.value = crepo.search(searchingWord)
        }
    }
}