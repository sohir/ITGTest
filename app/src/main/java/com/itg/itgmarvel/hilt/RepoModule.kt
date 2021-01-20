package com.itg.itgmarvel.hilt

import com.itg.itgmarvel.characterdetails.CharacterDetailsRepo
import com.itg.itgmarvel.characterslist.CharactersListRepo
import com.itg.itgmarvel.network.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepoModule {
    @Provides
    @ActivityRetainedScoped
    fun provideUserCharactersListRepo(apis: ApiServices):CharactersListRepo{
        return CharactersListRepo(apis)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideCharacterDetailsRepo(apis: ApiServices):CharacterDetailsRepo{
        return CharacterDetailsRepo(apis)
    }
}