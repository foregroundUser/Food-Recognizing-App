package com.azamovhudstc.foodapprecoginizng.di

import com.azamovhudstc.foodapprecoginizng.repo.AppRepository
import com.azamovhudstc.foodapprecoginizng.repo.imp.AppRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun getPostsRepository(impl: AppRepositoryImp): AppRepository

}