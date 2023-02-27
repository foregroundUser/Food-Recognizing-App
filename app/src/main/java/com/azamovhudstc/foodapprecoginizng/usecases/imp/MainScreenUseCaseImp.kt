package com.azamovhudstc.foodapprecoginizng.usecases.imp

import com.azamovhudstc.foodapprecoginizng.repo.AppRepository
import com.azamovhudstc.buisnessapp.usecases.MainScreenUseCase
import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainScreenUseCaseImp @Inject constructor(private val appRepository: AppRepository) :
    MainScreenUseCase {
    override fun getCollectionTypeByList(type:String): Flow<Result<ArrayList<ProductFireBase>>> {
        return appRepository.getAllFoodsByeType(type)
    }

}