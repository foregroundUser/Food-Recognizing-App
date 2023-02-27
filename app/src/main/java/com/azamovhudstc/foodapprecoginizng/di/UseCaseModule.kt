package com.azamovhudstc.foodapprecoginizng.di

import com.azamovhudstc.buisnessapp.usecases.MainScreenUseCase
import com.azamovhudstc.foodapprecoginizng.usecases.imp.MainScreenUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @Binds
    fun mainScreenUseCase(imp: MainScreenUseCaseImp): MainScreenUseCase
}