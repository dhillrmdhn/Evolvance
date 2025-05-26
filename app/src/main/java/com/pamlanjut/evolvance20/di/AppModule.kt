package com.pamlanjut.evolvance20.di

import com.pamlanjut.evolvance20.view.AppViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppViewModel(): AppViewModel {
        return AppViewModel()
    }
}
