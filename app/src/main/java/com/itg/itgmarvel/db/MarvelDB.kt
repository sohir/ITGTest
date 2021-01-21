package com.itg.itgmarvel.db

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.itg.itgmarvel.models.CharactersListResponseModel

@Database(entities =[CharactersListResponseModel.Data.Result::class],version = 1)
//@TypeConverters(Converters::class,DBConverters::class)

abstract class MarvelDB :RoomDatabase() {
    companion object{
        //Volatile: this var is available for all other threads immediately
        @Volatile private var instance: MarvelDB?=null
        private val LOCK = Any()
        operator fun invoke (context: Context)= instance?: synchronized(LOCK){
            instance ?: buildDataBase(context).also {
                instance = it
            }
        }

        private fun buildDataBase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            MarvelDB::class.java,
            "marvel.db"
        ).build()
    }
    abstract fun charactersDoa():CharactersDoa
}