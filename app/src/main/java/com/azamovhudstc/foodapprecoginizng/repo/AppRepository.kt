package com.azamovhudstc.foodapprecoginizng.repo
import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    ////SAmple AppRepository
    fun getAllFoodsByeType(type:String): Flow<Result<ArrayList<ProductFireBase>>>
}