package com.mshdabiola.data.di

import com.mshdabiola.data.repository.ModelRepository
import com.mshdabiola.data.repository.RealModelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindModelRepository(realModelRepository: RealModelRepository): ModelRepository
}
