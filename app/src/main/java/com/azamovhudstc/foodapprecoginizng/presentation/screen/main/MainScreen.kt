package com.azamovhudstc.foodapprecoginizng.presentation.screen.main

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.buisnessapp.ui.adapters.MainAdapter
import com.azamovhudstc.buisnessapp.vm.MainScreenViewModel
import com.azamovhudstc.foodapprecoginizng.R
import com.azamovhudstc.foodapprecoginizng.vm.imp.MainScreenViewModelImp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_screen.*

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.main_screen) {
    private val viewModel: MainScreenViewModel by viewModels<MainScreenViewModelImp>()
    private val adapter by lazy { MainAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(
                R.id.homeScreen,
                null,
                NavOptions.Builder().setPopUpTo(R.id.mainScreen, true).build()
            )
        }
        viewModel.products.observe(this){
            adapter.submitList(it)

        }
        viewModel.progressLiveData.observe(this){
            if (it){
                progressPrdoucts.visibility=View.VISIBLE

            }
            else{
                progressPrdoucts.visibility=View.INVISIBLE
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val string = arguments?.getString("type")
        println("asasdas $string")

        viewModel.getBlindsByCollectionType(type = string!!, filter  ="")
        rv_products.adapter=adapter
    }

}