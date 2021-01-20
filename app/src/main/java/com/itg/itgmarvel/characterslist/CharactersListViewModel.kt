package com.itg.itgmarvel.characterslist

import android.app.Application
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itg.itgmarvel.R
import com.itg.itgmarvel.network.LoadingState
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

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState> = _loadingState
    val errorMessage=MutableLiveData<String?>("")

    init {
    charctersList()
}
    fun charctersList() {
        _loadingState.value=(LoadingState.LOADING)

        _viewModelScope.launch {
            try {
                repo.charactersListRequest()
                _loadingState.value=(LoadingState.LOADED)
                if (responseModel.value?.data?.count==0){
                    _loadingState.value=(LoadingState.error(null))
                    errorMessage.value= application.getString(R.string.no_data)
                }
                Log.v("list", "result code is :${responseModel.value?.code.toString()}")

            } catch (throwable: Throwable) {
                _loadingState.value=(LoadingState.error(null))
                errorMessage.value= application.getString(R.string.error_happens)
                Log.v("list", "msg error: ${throwable?.message}")
                when (throwable) {
                    is Exception -> {
                        Log.v("list", "msg error Exception: ${throwable?.message}")
                        _loadingState.value=(LoadingState.error(null))
                        errorMessage.value= application.getString(R.string.no_connection)
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