package com.example.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {
    private lateinit var binding: FragmentAddContactBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddContactBinding.inflate(inflater, container, false)

        binding.toolbarAddContact.title = "Add Contact"

        binding.buttonSave.setOnClickListener {
            val contact_name = binding.editTextContactName.text.toString()
            val contact_no = binding.editTextContactNo.text.toString()
            saveContact(contact_name,contact_no)
        }
        return binding.root
    }

    private fun saveContact(kisi_ad : String, kisi_tel : String){
        Log.e("Save contact", "$kisi_ad - $kisi_tel")
    }
}