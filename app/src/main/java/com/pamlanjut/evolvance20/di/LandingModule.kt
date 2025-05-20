package com.pamlanjut.evolvance20.di

import com.pamlanjut.evolvance20.data.repository.landing.LandingRepository
import com.pamlanjut.evolvance20.data.repository.landing.LandingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LandingModule {
    @Binds
    abstract fun bindLandingRepository(
        impl: LandingRepositoryImpl
    ): LandingRepository
}
