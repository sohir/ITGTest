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
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Singleton

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepoModule {
    @Provides
    @ActivityRetainedScoped
    fun provideUserCharactersListRepo(apis: ApiServices,db: MarvelDB,helper:HelperClass):CharactersListRepo{
        return CharactersListRepo(apis,db,helper )
    }

    @Provides
    @ActivityRetainedScoped
    fun provideCharacterDetailsRepo(apis: ApiServices):CharacterDetailsRepo{
        return CharacterDetailsRepo(apis)
    }

}