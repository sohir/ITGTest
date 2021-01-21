package com.itg.itgmarvel.hilt

import android.app.Application
import com.itg.itgmarvel.characterdetails.CharacterDetailsRepo
import com.itg.itgmarvel.characterslist.CharactersListRepo
import com.itg.itgmarvel.db.MarvelDB
import com.itg.itgmarvel.network.ApiServices
import com.itg.itgmarvel.utility.HelperClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DBModule {

    //DB Module
    @Provides
    @Singleton
    fun DataBaseRoom(application: Application): MarvelDB {
        return MarvelDB(application)
    }
    @Provides
    @Singleton
    fun HelperUtility():HelperClass{
        return HelperClass()
    }
}