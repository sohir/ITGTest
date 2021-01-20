package com.itg.itgmarvel.characterdetails

import android.app.Application
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.itg.itgmarvel.R
import com.itg.itgmarvel.characterslist.CharactersListRepo
import com.itg.itgmarvel.network.LoadingState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class DetailsViewModel@ViewModelInject constructor(
    val application: Application,val detailsRepo: CharacterDetailsRepo ,@Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val characterName = savedStateHandle.get<String>("name")
    val characterDescription = savedStateHandle.get<String>("description")
    val characterImg = savedStateHandle.get<String>("img")
    val characterId = savedStateHandle.get<Int>("charID")
    val job = SupervisorJob()

    val _viewModelScope = CoroutineScope(job + Dispatchers.Main)
    var responseModel = detailsRepo.responseModel


    init {
        chomicsList()
        Log.v("details"," its data: id ${characterId}, name ${characterName}, des ${characterDescription}, img ${characterImg}")
    }
    fun chomicsList() {
      //  _loadingState.value=(LoadingState.LOADING)

        _viewModelScope.launch {
            try {
               detailsRepo.characterComicstRequest(characterId.toString())
            /*    _loadingState.value=(LoadingState.LOADED)
                if (responseModel.value?.data?.count==0){
                    _loadingState.value=(LoadingState.error(null))
                    errorMessage.value= application.getString(R.string.no_data)
                }*/
                Log.v("comics", "result code is :${responseModel.value?.code.toString()}")
                Log.v("comics", "result name is :${responseModel.value?.data?.results?.get(0)?.title}")

            } catch (throwable: Throwable) {
            /*    _loadingState.value=(LoadingState.error(null))
                errorMessage.value= application.getString(R.string.error_happens)*/
                Log.v("comics", "msg error: ${throwable.message}")
                when (throwable) {
                    is Exception -> {
                        Log.v("comics", "msg error Exception: ${throwable.message}")
                 /*       _loadingState.value=(LoadingState.error(null))
                        errorMessage.value= application.getString(R.string.no_connection)*/
                    }
                }
            }
        }
    }



    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}