package com.example.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentContactDetailBinding

class ContactDetailFragment : Fragment() {
    private lateinit var binding: FragmentContactDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContactDetailBinding.inflate(inflater, container, false)

        binding.toolbarContactDetail.title = "Contact Detail"

        val bundle : ContactDetailFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.editTextContactName.setText(gelenKisi.kisi_ad)
        binding.editTextContactNo.setText(gelenKisi.kisi_tel)

        binding.buttonUpdate.setOnClickListener {
            val updatedContactName = binding.editTextContactName.text.toString()
            val updatedContactNo  = binding.editTextContactNo.text.toString()

            updateContact(gelenKisi.kisi_id,updatedContactName,updatedContactNo)
        }

        return binding.root
    }

    private fun updateContact(kisi_id : Int, kisi_ad : String, kisi_tel : String){
        Log.e("Update contact", "$kisi_id - $kisi_ad - $kisi_tel")
    }
}