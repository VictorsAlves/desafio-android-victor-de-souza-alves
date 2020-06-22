package com.accenture.desafio.components.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.accenture.desafio.R
import com.accenture.desafio.components.recyclerview.viewholder.CharacterViewHolder
import com.accenture.desafio.databinding.CharacterViewHolderBinding
import com.accenture.desafio.viewmodel.Character
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class CharacterAdapter(
    var list: MutableList<Character>,
    val callback: (conversion: Character) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<CharacterViewHolderBinding>(
            LayoutInflater.from(parent.context),
            R.layout.character_view_holder,
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CharacterViewHolder) {
            val item = list[position]
            holder.binding.character = item
            Picasso.get().
            load(item.image).fit().centerCrop().
            placeholder(R.drawable.background).
            into(holder.binding.imageCharacter, object : Callback {
                override fun onSuccess() {
                    holder.binding.imageCharacter.scaleType = ImageView.ScaleType.CENTER
                }

                override fun onError(e: Exception?) {}
            })
            holder.binding.cardViewCharacter.setOnClickListener {
                callback.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int = list.size

}