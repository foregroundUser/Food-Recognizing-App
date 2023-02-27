package com.azamovhudstc.foodapprecoginizng.presentation.viewmodel.home.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azamovhudstc.foodapprecoginizng.presentation.viewmodel.home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl  @Inject constructor():ViewModel(),HomeViewModel{
    override var foodsButtonLiveData: MutableLiveData<Unit> = MutableLiveData()
    override var productsButtonLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun clickFoodsButton() {
        foodsButtonLiveData.value=Unit
    }

    override fun clickProductsButton() {
        productsButtonLiveData.value=Unit
    }
}