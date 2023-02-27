package com.azamovhudstc.foodapprecoginizng.data.remote.api

import com.azamovhudstc.foodapprecoginizng.data.remote.response.ProductResponse
import com.azamovhudstc.foodapprecoginizng.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface EdamanApi {
    @GET("food-database/v2/parser")
    suspend fun getQueryByImages(
        @Query("app_id") clientId: String = Constants.API_ID,
        @Query("app_key") per_page: String = Constants.API_KEY,
        @Query("ingr") order_by: String ,

        @Query("page") page:Int,
        @Query("orientation") orientation: String = "portrait",
        @Query("query") query: String
    ): Response<ProductResponse>
}