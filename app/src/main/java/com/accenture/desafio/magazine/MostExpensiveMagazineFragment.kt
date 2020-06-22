package com.accenture.desafio.magazine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.accenture.desafio.R
import com.accenture.desafio.character.CharacterContract
import com.accenture.desafio.databinding.FragmentCharacterDetailBinding
import com.accenture.desafio.databinding.FragmentMostExpensiveMagazineBinding
import com.accenture.desafio.viewmodel.CharacterViewModel
import com.accenture.desafio.viewmodel.MagazineViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class MostExpensiveMagazineFragment : Fragment(), MagazineContract.MagazinePresenterOutput {

    private lateinit var binding: FragmentMostExpensiveMagazineBinding
    private lateinit var magazineViewModel: MagazineViewModel
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var presenter: MagazineContract.MagazinePresenterInput
    private lateinit var router: RouterMagazine

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMostExpensiveMagazineBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterViewModel =
            activity?.run {
                ViewModelProvider(requireActivity()).get(CharacterViewModel::class.java)
            } ?: CharacterViewModel()

        magazineViewModel =
            activity?.run {
                ViewModelProvider(requireActivity()).get(MagazineViewModel::class.java)
            } ?: MagazineViewModel()

        router = RouterMagazine(binding.root)
        presenter = MagazinePresenter(this, requireActivity(), magazineViewModel.magazineLiveData)
        presenter.startMagazine(characterViewModel.clickCharacter.id)
        binding.magazine = magazineViewModel.magazine

        magazineViewModel.magazineLiveData.observe(viewLifecycleOwner,
            Observer {
                magazineViewModel.magazine = it
                binding.magazine = it
                if(magazineViewModel.magazine.image.isNotEmpty()) {
                    Picasso.get().load(magazineViewModel.magazine.image).fit().centerCrop()
                        .into(binding.imageMagazine, object : Callback {
                            override fun onSuccess() {
                                binding.imageMagazine.scaleType = ImageView.ScaleType.CENTER
                            }

                            override fun onError(e: Exception?) {}
                        })
                }
            })
    }

    override fun returnError(error: String) {
        val snackbar = Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG)
        snackbar.show()
        router.popBackStack()
    }
}