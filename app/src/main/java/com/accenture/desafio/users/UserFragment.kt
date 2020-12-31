package com.accenture.desafio.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.accenture.desafio.R
import com.accenture.desafio.character.CharacterContract
import com.accenture.desafio.character.RouterCharacter
import com.accenture.desafio.components.recyclerview.adapter.CharacterAdapter
import com.accenture.desafio.databinding.FragmentCharacterBinding
import com.accenture.desafio.viewmodel.CharacterViewModel

class UserFragment : Fragment(), UserContract.UserPresenterOutput {

    private lateinit var binding: FragmentCharacterBinding
    private lateinit var presenter: UserContract.UserPresenterInput
    private lateinit var userViewModel: UsersViewModel
   // private lateinit var characterAdapter: CharacterAdapter
    //private lateinit var router: RouterCharacter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun returnError(error: String) {
        TODO("Not yet implemented")
    }


}