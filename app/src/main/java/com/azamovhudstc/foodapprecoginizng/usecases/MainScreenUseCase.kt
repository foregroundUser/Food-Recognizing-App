package com.azamovhudstc.buisnessapp.usecases

import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase
import kotlinx.coroutines.flow.Flow

interface MainScreenUseCase {
    fun getCollectionTypeByList(type:String): Flow<Result<ArrayList<ProductFireBase>>>
}