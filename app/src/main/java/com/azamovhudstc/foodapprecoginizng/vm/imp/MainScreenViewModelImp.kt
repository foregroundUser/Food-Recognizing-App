package com.azamovhudstc.foodapprecoginizng.vm.imp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azamovhudstc.buisnessapp.usecases.MainScreenUseCase
import com.azamovhudstc.buisnessapp.vm.MainScreenViewModel
import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.Duration
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModelImp @Inject constructor(private val blindsScreenUseCase: MainScreenUseCase):MainScreenViewModel ,ViewModel() {
    override val progressLiveData: MutableLiveData<Boolean> =MutableLiveData()
    override val products: MutableLiveData<ArrayList<ProductFireBase>> =MutableLiveData()
    override val fullPriceLiveData:MutableLiveData<String> = MutableLiveData()
    override fun getBlindsByCollectionType(type:String,filter:String) {
        progressLiveData.value=true
        blindsScreenUseCase.getCollectionTypeByList(type).onEach {
            it.onSuccess { result ->
                viewModelScope.launch {
                    delay(300)
                }
                products.value=result
                progressLiveData.value = false
            }
                it.onFailure {Error->
                    println("Error"+Error.message)

                }
            }.launchIn(viewModelScope)
        }
    }
