package com.itg.itgmarvel.characterslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itg.itgmarvel.db.MarvelDB
import com.itg.itgmarvel.models.CharactersListResponseModel
import com.itg.itgmarvel.network.ApiServices
import com.itg.itgmarvel.utility.HASHFIRSTPART
import com.itg.itgmarvel.utility.HelperClass
import com.itg.itgmarvel.utility.PUBLICKEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import javax.inject.Inject

class CharactersListRepo @Inject constructor(val apiServices: ApiServices,
val db:MarvelDB, val helper: HelperClass
) {
    private var _ResponseModel = MutableLiveData<CharactersListResponseModel>(null)
    var responseModel : LiveData<CharactersListResponseModel> = _ResponseModel

    private var _CharactersListModel = MutableLiveData<ArrayList<CharactersListResponseModel.Data.Result>>(null)
    var charactersListModel : LiveData<ArrayList<CharactersListResponseModel.Data.Result>> = _CharactersListModel

    var _DbCount: MutableLiveData<Int> = MutableLiveData<Int>(0)
    var dbCount : LiveData<Int> = _DbCount

    suspend fun getCharactersCount(){
        withContext(Dispatchers.IO){
            _DbCount.postValue(async { db.charactersDoa().getRowCount()}.await())
        }
    }

    suspend fun charactersListRequestServer(ts:String){
        withContext(Dispatchers.IO){

           val result = apiServices.getCharacters(ts, PUBLICKEY,helper.md5Encript("${ts}${HASHFIRSTPART}")).await()
           _ResponseModel.postValue(result)
            _CharactersListModel.postValue(result.data.results as ArrayList<CharactersListResponseModel.Data.Result>)
            async {
                for (item in result.data.results){
                    db.charactersDoa().addCharacter(item)
                }
            }.await()
        }
    }

    suspend fun charactersListRequestDB() {
        withContext(Dispatchers.IO) {
            async {
                _CharactersListModel.postValue(
                    db.charactersDoa().getCharacter() as ArrayList<CharactersListResponseModel.Data.Result>?
                )

            }.await()
        }
    }

}