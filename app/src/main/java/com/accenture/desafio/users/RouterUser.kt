package com.accenture.desafio.users

import android.view.View
import androidx.navigation.findNavController
import com.accenture.desafio.R

class RouterUser(private val view: View) {
    fun navigationToUser() {
        view.findNavController()
            .navigate(R.id.action_characterFragment_to_characterDetailFragment)
    }
}