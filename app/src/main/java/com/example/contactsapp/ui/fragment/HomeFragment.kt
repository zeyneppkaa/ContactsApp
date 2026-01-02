package com.example.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp.R
import com.example.contactsapp.data.entity.Kisiler
import com.example.contactsapp.databinding.FragmentHomeBinding
import com.example.contactsapp.ui.adapter.ContactAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.toolbarHome.title = "Home"
        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val contactsList = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "1111")
        val k2 = Kisiler(2,"Zeynep","2222")
        val k3 = Kisiler(3,"Beyza","3333")
        contactsList.add(k1)
        contactsList.add(k2)
        contactsList.add(k3)

        val contactsAdapter = ContactAdapter(requireContext(), contactsList)
        binding.rv.adapter = contactsAdapter

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addContactFragment)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })

        return binding.root
    }

    fun search(searchingWord : String){
        Log.e("Search Contact", searchingWord)
    }
}