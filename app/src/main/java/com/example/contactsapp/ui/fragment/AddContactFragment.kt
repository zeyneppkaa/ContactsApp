package com.example.contactsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentAddContactBinding
import com.example.contactsapp.ui.viewmodel.AddContactViewModel

class AddContactFragment : Fragment() {
    private lateinit var binding: FragmentAddContactBinding
    private lateinit var viewModel : AddContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddContactViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_contact, container, false)
        binding.addContactFragmentObject = this
        binding.addContactToolbarTitle = "Add Contact"
        binding.buttonSave.setOnClickListener {
            val contact_name = binding.editTextContactName.text.toString()
            val contact_no = binding.editTextContactNo.text.toString()
            saveContactBtn(contact_name,contact_no)
        }
        return binding.root
    }

    private fun saveContactBtn(kisi_ad : String, kisi_tel : String){
        viewModel.saveContact(kisi_ad,kisi_tel)
    }
}