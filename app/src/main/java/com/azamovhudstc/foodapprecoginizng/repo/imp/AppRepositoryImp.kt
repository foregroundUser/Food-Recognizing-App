package com.azamovhudstc.foodapprecoginizng.repo.imp

import android.os.Build
import androidx.annotation.RequiresApi
import com.azamovhudstc.buisnessapp.repo.AppRepository
import com.azamovhudstc.foodapprecoginizng.data.remote.api.EdamanApi
import com.azamovhudstc.foodapprecoginizng.data.remote.response.ProductResponse
import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.collections.ArrayList

class AppRepositoryImp @Inject constructor(private val firebaseFireStore: FirebaseFirestore,private val edamanApi: EdamanApi) :
    AppRepository {
    override fun searchByQueryFoods(query: String): Flow<Result<ProductResponse>> = flow{
        val queryByFoods = edamanApi.queryByFoods(ingr = query)
        if (queryByFoods.isSuccessful) {
            emit(Result.success(queryByFoods.body()!!))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)

    override fun getAllFoodsByeType(type:String): Flow<Result<ArrayList<ProductFireBase>>> =callbackFlow   <Result<ArrayList<ProductFireBase>>> {
            firebaseFireStore.collection(type)
                .addSnapshotListener { value, error ->
                    val list = ArrayList<ProductFireBase>()
                    value?.forEach { document ->
                        list.add(
                            ProductFireBase(
                                name = document.data["name"].toString(),
                                image=document.data["imgUrl"].toString(),
                                category=document.data["category"].toString(),
                                calorie=document.data["calorie"].toString(),

                            )
                        )
                    }
                    trySend(Result.success(list))
                }
        awaitClose()
    }.flowOn(Dispatchers.IO)
}