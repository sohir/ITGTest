package com.itg.itgmarvel.characterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itg.itgmarvel.models.CharactersListResponseModel
import com.itg.itgmarvel.models.ComicsResponseModel
import com.itg.itgmarvel.network.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterDetailsRepo @Inject constructor(val apiServices: ApiServices) {

    private var _ResponseModel = MutableLiveData<ComicsResponseModel>(null)
    var responseModel : LiveData<ComicsResponseModel> = _ResponseModel

    suspend fun characterComicstRequest(charID:String){
        withContext(Dispatchers.IO){
           val result = apiServices.getComics(charID,"2","322fc34dbf9e1da7186fe9d067e45fb9","41f4c7dd26c7f7a2abd0f4ebfd271d6f").await()
            _ResponseModel.postValue(result)
        }
    }
}