package com.example.projectone_v02.data.di

import com.example.projectone_v02.data.api.ProjectApi
import com.example.projectone_v02.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(projectApi: ProjectApi):Repository{
        return Repository(projectApi)
    }
}