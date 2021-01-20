package com.itg.itgmarvel.characterslist

import android.app.Application
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CharactersListViewModel @ViewModelInject constructor(
    val application: Application,
    val repo: CharactersListRepo
) : ViewModel() {
    val job = SupervisorJob()
    val _viewModelScope = CoroutineScope(job + Dispatchers.Main)
    var responseModel = repo.responseModel
init {
    charctersList()
}
    fun charctersList() {
        _viewModelScope.launch {
            try {
                repo.charactersListRequest()
                Log.v("list", "result code is :${responseModel.value?.code.toString()}")

            } catch (throwable: Throwable) {

                Log.v("list", "msg error: ${throwable?.message}")

                when (throwable) {
                    is Exception -> {
                        Log.v("list", "msg error Exception: ${throwable?.message}")

                    }
                    is HttpException -> {
                        Log.v("list", "msg error HttpException: ${throwable?.message}")

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