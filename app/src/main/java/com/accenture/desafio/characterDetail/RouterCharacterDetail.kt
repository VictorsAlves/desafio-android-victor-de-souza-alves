package com.accenture.desafio.characterDetail

import android.view.View
import androidx.navigation.findNavController
import com.accenture.desafio.R

class RouterCharacterDetail(private val view: View) {

    fun popBackStack() = view.findNavController().popBackStack()

    fun navigationToMagazine() {
        view.findNavController()
            .navigate(R.id.action_characterDetailFragment_to_magazineFragment)
    }


}