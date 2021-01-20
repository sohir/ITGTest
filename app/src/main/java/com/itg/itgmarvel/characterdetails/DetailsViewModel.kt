package com.itg.itgmarvel.characterdetails

import android.app.Application
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.itg.itgmarvel.characterslist.CharactersListRepo

class DetailsViewModel@ViewModelInject constructor(
    val application: Application,@Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val characterName = savedStateHandle.get<String>("name")
    val characterDescription = savedStateHandle.get<String>("description")
    val characterImg = savedStateHandle.get<String>("img")
    val characterId = savedStateHandle.get<Int>("charID")

    init {
        Log.v("details"," its data: id ${characterId}, name ${characterName}, des ${characterDescription}, img ${characterImg}")
    }
}