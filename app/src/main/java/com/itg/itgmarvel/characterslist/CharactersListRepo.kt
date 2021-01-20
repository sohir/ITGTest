package com.itg.itgmarvel.characterslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itg.itgmarvel.models.CharactersListResponseModel
import com.itg.itgmarvel.network.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersListRepo @Inject constructor(val apiServices: ApiServices) {

    private var _ResponseModel = MutableLiveData<CharactersListResponseModel>(null)
    var responseModel : LiveData<CharactersListResponseModel> = _ResponseModel

    suspend fun charactersListRequest(){
        withContext(Dispatchers.IO){
           val result = apiServices.getCharacters("2","322fc34dbf9e1da7186fe9d067e45fb9","41f4c7dd26c7f7a2abd0f4ebfd271d6f").await()

            _ResponseModel.postValue(result)
        }
    }
}