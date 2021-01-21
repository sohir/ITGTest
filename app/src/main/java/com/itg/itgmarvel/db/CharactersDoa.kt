package com.itg.itgmarvel.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.itg.itgmarvel.models.CharactersListResponseModel


@Dao
interface CharactersDoa {
//onConflict = OnConflictStrategy.REPLACE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacter(character: CharactersListResponseModel.Data.Result)

    @Insert
    suspend fun addMultipleCharacters(vararg character: CharactersListResponseModel.Data.Result):List<Long>

    @Update
    suspend fun updateCharacter(character: CharactersListResponseModel.Data.Result)

    @Delete
    suspend fun deleteCharacter(character: CharactersListResponseModel.Data.Result)

    @Query("SELECT * FROM characters")
    suspend fun getCharacter():List<CharactersListResponseModel.Data.Result>


    @Query("DELETE FROM characters")
    suspend fun deleteOrders()


    @Query("SELECT COUNT(id) FROM characters")
    fun getRowCount(): Int
}