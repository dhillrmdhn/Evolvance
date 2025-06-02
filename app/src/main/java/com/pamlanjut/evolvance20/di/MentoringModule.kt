package com.pamlanjut.evolvance20.di

import com.pamlanjut.evolvance20.data.repository.mentoring.MentoringRepository
import com.pamlanjut.evolvance20.data.repository.mentoring.MentoringRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MentoringModule {

    @Binds
    abstract fun bindMentoringRepository(
        impl: MentoringRepositoryImpl
    ): MentoringRepository
}
