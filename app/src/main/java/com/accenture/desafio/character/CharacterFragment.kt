package com.accenture.desafio.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.accenture.desafio.components.recyclerview.adapter.CharacterAdapter
import com.accenture.desafio.databinding.FragmentCharacterBinding
import com.accenture.desafio.viewmodel.CharacterViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch


class CharacterFragment : Fragment(), CharacterContract.CharacterPresenterOutput {

    private lateinit var binding: FragmentCharacterBinding
    private lateinit var presenter: CharacterContract.CharacterPresenterInput
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var router: RouterCharacter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.coroutineScope.launch {

            router = RouterCharacter(view)

            characterViewModel =
                activity?.run {
                    ViewModelProvider(requireActivity()).get(CharacterViewModel::class.java)
                } ?: CharacterViewModel()

            presenter =
                CharacterPresenter(
                    this@CharacterFragment,
                    requireActivity(),
                    characterViewModel.chacarterLiveData
                )

            if (characterViewModel.list.isEmpty()) {
                presenter.startCharacters()
            }

            characterAdapter = CharacterAdapter(characterViewModel.list, callback = {
                characterViewModel.clickCharacter = it
                router.navigationToCharacterDetail()
            })

            binding.listCharacter.apply {
                adapter = characterAdapter
                layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrollStateChanged(
                        recyclerView: RecyclerView,
                        newState: Int
                    ) {
                        super.onScrollStateChanged(recyclerView, newState)
                        if (!recyclerView.canScrollVertically(1)) {
                            presenter.startCharacters()
                        }
                    }
                })
            }

            characterViewModel.chacarterLiveData.observe(viewLifecycleOwner,
                Observer {
                    characterViewModel.list.addAll(it)
                    characterAdapter.notifyDataSetChanged()
                })
        }
    }

    override fun returnError(error: String) {
        val snackbar = Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG)
        snackbar.show()
    }

}