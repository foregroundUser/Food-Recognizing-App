package com.azamovhudstc.buisnessapp.repo
import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getAllFoodsByeType(type:String): Flow<Result<ArrayList<ProductFireBase>>>
}