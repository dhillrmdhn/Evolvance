package com.pamlanjut.evolvance20.di

import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepositoryImpl
import com.pamlanjut.evolvance20.data.repository.bootcamp.BootcampRepository
import com.pamlanjut.evolvance20.data.repository.bootcamp.BootcampRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BootcampModule {

    @Binds
    abstract fun bindBootcampRepository(
        impl: BootcampRepositoryImpl
    ): BootcampRepository
}