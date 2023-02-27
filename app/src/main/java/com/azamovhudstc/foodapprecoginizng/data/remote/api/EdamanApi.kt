package com.azamovhudstc.foodapprecoginizng.data.remote.api

import com.azamovhudstc.foodapprecoginizng.data.remote.response.ProductResponse
import com.azamovhudstc.foodapprecoginizng.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface EdamanApi {
    @GET("food-database/v2/parser")
    suspend fun queryByFoods(
        @Query("app_id") clientId: String = Constants.API_ID,
        @Query("app_key") per_page: String = Constants.API_KEY,
        @Query("ingr") ingr: String,
        @Query("category") category: String ="generic-foods"): Response<ProductResponse>
}