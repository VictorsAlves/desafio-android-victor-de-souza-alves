package com.accenture.desafio.magazine

import android.view.View
import androidx.navigation.findNavController
import com.accenture.desafio.R

class RouterMagazine(private val view: View) {

    fun popBackStack() = view.findNavController().popBackStack()
}