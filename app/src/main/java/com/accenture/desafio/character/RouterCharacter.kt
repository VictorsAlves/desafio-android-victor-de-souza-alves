package com.accenture.desafio.character

import android.view.View
import androidx.navigation.findNavController
import com.accenture.desafio.R

class RouterCharacter(private val view: View) {

    fun navigationToCharacterDetail() {
        view.findNavController()
            .navigate(R.id.action_characterFragment_to_characterDetailFragment)
    }

}