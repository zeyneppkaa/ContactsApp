package com.example.contactsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentContactDetailBinding
import com.example.contactsapp.ui.viewmodel.ContactDetailViewModel
import kotlin.getValue

class ContactDetailFragment : Fragment() {
    private lateinit var binding: FragmentContactDetailBinding
    private lateinit var viewModel : ContactDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : ContactDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_detail, container, false)

        binding.contactDetailFragmentObject = this
        binding.contactDetailToolbarTitle = "Contact Detail"

        val bundle : ContactDetailFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi
        binding.contactObject = gelenKisi

        binding.buttonUpdate.setOnClickListener {
            val updatedContactName = binding.editTextContactName.text.toString()
            val updatedContactNo  = binding.editTextContactNo.text.toString()
            updateContactBtn(gelenKisi.kisi_id,updatedContactName,updatedContactNo)
        }
        return binding.root
    }

    private fun updateContactBtn(kisi_id : Int, kisi_ad : String, kisi_tel : String){
        viewModel.updateContact(kisi_id, kisi_ad, kisi_tel)
    }
}