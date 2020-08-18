package com.accenture.desafio.screencompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import com.accenture.desafio.character.CharacterContract
import com.accenture.desafio.character.CharacterPresenter
import com.accenture.desafio.character.RouterCharacter
import com.accenture.desafio.components.recyclerview.adapter.CharacterAdapter
import com.accenture.desafio.databinding.FragmentCharacterBinding
import com.accenture.desafio.screencompose.ui.CharacterViewComposeTheme
import com.accenture.desafio.viewmodel.CharacterViewModel
import kotlinx.coroutines.launch

class CharacterView() : AppCompatActivity(), CharacterContract.CharacterPresenterOutput {

    private lateinit var binding: FragmentCharacterBinding
    private lateinit var presenter: CharacterContract.CharacterPresenterInput
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var router: RouterCharacter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       presenter.startCharacters()





        characterAdapter = CharacterAdapter(characterViewModel.list, callback = {
            characterViewModel.clickCharacter = it
            router.navigationToCharacterDetail()
        })

        setContent {
            CharacterViewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Column {
            Row() {
                Text(text = "Hello $name!")

            }
            Row() {
                Text(text = "Hello $name!")

            }
        }


    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CharacterViewComposeTheme {
            Greeting("Android")
        }


    }

    override fun returnError(error: String) {
        TODO("Not yet implemented")
    }
}