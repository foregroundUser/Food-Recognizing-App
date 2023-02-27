package com.azamovhudstc.buisnessapp.vm

import androidx.lifecycle.MutableLiveData
import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase

interface MainScreenViewModel {
    val progressLiveData:MutableLiveData<Boolean>
    val fullPriceLiveData:MutableLiveData<String>
    val products:MutableLiveData<ArrayList<ProductFireBase>>
    fun getBlindsByCollectionType(type:String, filter:String)

}