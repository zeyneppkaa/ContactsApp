package com.example.contactsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.contactsapp.R
import com.example.contactsapp.data.entity.Kisiler
import com.example.contactsapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addContactFragment)
        }

        binding.buttonDetail.setOnClickListener {
            val kisi = Kisiler(1,"Zeynep","1111")
            val goToDetailPage = HomeFragmentDirections.actionHomeFragmentToContactDetailFragment(kisi)
            Navigation.findNavController(it).navigate(goToDetailPage)
        }
        return binding.root
    }
}