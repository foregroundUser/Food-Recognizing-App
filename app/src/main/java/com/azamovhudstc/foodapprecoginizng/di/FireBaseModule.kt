package com.azamovhudstc.foodapprecoginizng.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FireBaseModule {
    @[Provides Singleton]
    fun getFireStore():FirebaseFirestore=FirebaseFirestore.getInstance()

}