package com.azamovhudstc.buisnessapp.repo
import com.azamovhudstc.foodapprecoginizng.data.remote.response.ProductResponse
import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun searchByQueryFoods(query:String):Flow<Result<ProductResponse>>
    fun getAllFoodsByeType(type:String): Flow<Result<ArrayList<ProductFireBase>>>
}