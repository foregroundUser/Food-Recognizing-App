package com.azamovhudstc.foodapprecoginizng.data.remote.response

data class Measure(
    val label: String,
    val qualified: List<Qualified>,
    val uri: String
)