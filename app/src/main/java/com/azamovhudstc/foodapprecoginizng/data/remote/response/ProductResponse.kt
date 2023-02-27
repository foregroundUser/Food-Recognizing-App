package com.azamovhudstc.foodapprecoginizng.data.remote.response

data class ProductResponse(
    val _links: Links,
    val hints: List<Hint>,
    val parsed: List<Parsed>,
    val text: String
)