package com.example.contactsapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.data.entity.Kisiler
import com.example.contactsapp.databinding.CardDesignBinding
import com.example.contactsapp.ui.fragment.HomeFragmentDirections
import com.google.android.material.snackbar.Snackbar

class ContactAdapter(var mContext: Context, var contactsList : List<Kisiler>)
    : RecyclerView.Adapter<ContactAdapter.CardDesignHolder>(){
    inner class CardDesignHolder(var design : CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val contact = contactsList.get(position)
        val d = holder.design

        d.textViewContactName.text = contact.kisi_ad
        d.textViewContactNo.text = contact.kisi_tel

        d.cardViewLine.setOnClickListener {
            val goToDetail = HomeFragmentDirections.actionHomeFragmentToContactDetailFragment(kisi = contact )
            Navigation.findNavController(it).navigate(goToDetail)
        }

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to delete ${contact.kisi_ad} ?", Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    delete(contact.kisi_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    fun delete(kisi_id : Int){
        Log.e("Delete Contact", kisi_id.toString())
    }

}