package com.azamovhudstc.foodapprecoginizng.presentation.viewmodel.home

import androidx.lifecycle.MutableLiveData

interface HomeViewModel {

    var foodsButtonLiveData:MutableLiveData<Unit>
    var productsButtonLiveData:MutableLiveData<Unit>

    fun clickFoodsButton()
    fun clickProductsButton()
}