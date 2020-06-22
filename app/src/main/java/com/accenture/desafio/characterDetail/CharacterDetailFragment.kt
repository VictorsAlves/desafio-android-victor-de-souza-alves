package com.accenture.desafio.characterDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.accenture.desafio.R
import com.accenture.desafio.databinding.FragmentCharacterBinding
import com.accenture.desafio.databinding.FragmentCharacterDetailBinding
import com.accenture.desafio.viewmodel.CharacterViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var router: RouterCharacterDetail

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterViewModel =
            activity?.run {
                ViewModelProvider(requireActivity()).get(CharacterViewModel::class.java)
            } ?: CharacterViewModel()
        router = RouterCharacterDetail(binding.root)
        binding.character = characterViewModel.clickCharacter

        Picasso.get().load(characterViewModel.clickCharacter.image).fit().centerCrop()
            .into(binding.imageCharacterDetail, object : Callback {
                override fun onSuccess() {
                    binding.imageCharacterDetail.scaleType = ImageView.ScaleType.CENTER
                }

                override fun onError(e: Exception?) {}
            })

        binding.textMoreHq.setOnClickListener {
            router.navigationToMagazine()
        }
    }
}