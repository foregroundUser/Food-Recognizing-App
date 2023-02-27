package com.azamovhudstc.foodapprecoginizng.presentation.screen.home

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.foodapprecoginizng.utils.BuildConfigs as BuildConfig
import com.azamovhudstc.foodapprecoginizng.R
import com.azamovhudstc.foodapprecoginizng.data.local.sharedpref.AppReference
import com.azamovhudstc.foodapprecoginizng.presentation.viewmodel.home.HomeViewModel
import com.azamovhudstc.foodapprecoginizng.presentation.viewmodel.home.impl.HomeViewModelImpl
import com.azamovhudstc.foodapprecoginizng.utils.Constants.END_SCALE
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import hotchemi.android.rate.AppRate
import kotlinx.android.synthetic.main.screen_home.*
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {
  private  val viewModel:HomeViewModel by viewModels<HomeViewModelImpl>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.foodsButtonLiveData.observe(this,foodsObserver)
        viewModel.productsButtonLiveData.observe(this,productObserver)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDarkOrLightMode()

        appRate()
        setUpNavigationDrawer()
        clickButtons()
    }


    private  fun initDarkOrLightMode(){
        var inflater =view?.findViewById<NavigationView>(R.id.main_navigation_menu)?.getHeaderView(0)
        var view =inflater!!.findViewById<ImageView>(R.id.mode_app)
        val sharedPreferences = AppReference(requireContext())
        val isDarkModeOn = sharedPreferences.getDarkMode()
        if (isDarkModeOn == true) {
            AppCompatDelegate
                .setDefaultNightMode(
                    AppCompatDelegate
                        .MODE_NIGHT_YES);
            view.setImageResource(R.drawable.ic_baseline_wb_sunny_24)
        }
        else {
            AppCompatDelegate
                .setDefaultNightMode(
                    AppCompatDelegate
                        .MODE_NIGHT_NO);
            view.setImageResource(R.drawable.ic_baseline_dark_mode_24)
        }
        view.setOnClickListener {
            if (isDarkModeOn == true) {
                AppCompatDelegate
                    .setDefaultNightMode(
                        AppCompatDelegate
                            .MODE_NIGHT_NO
                    );
                sharedPreferences.setDarkMode(false)
                view.setImageResource(R.drawable.ic_baseline_dark_mode_24)
            } else {
                AppCompatDelegate
                    .setDefaultNightMode(
                        AppCompatDelegate
                            .MODE_NIGHT_YES
                    );
                sharedPreferences.setDarkMode(true)
                view.setImageResource(R.drawable.ic_baseline_wb_sunny_24)
            }
        }
    }
    private fun setUpNavigationDrawer(){
        main_navigation_menu.bringToFront()
        setting.setOnClickListener {
            UIUtil.hideKeyboard(requireActivity())
            if (my_drawer_layout.isDrawerVisible(GravityCompat.END))
                my_drawer_layout.closeDrawer(
                    GravityCompat.END
                ) else my_drawer_layout.openDrawer(GravityCompat.END)
        }
        main_navigation_menu.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.rate_us ->{
                    val url =
                        "https://play.google.com/store/apps/details?id=${com.azamovhudstc.foodapprecoginizng.BuildConfig.APPLICATION_ID.toString()}"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                    my_drawer_layout.closeDrawer(GravityCompat.END)

                }
                R.id.share_up->{
                    val sharingIntent = Intent(Intent.ACTION_SEND)
                    sharingIntent.type = "text/plain"
                    val shareBody = "Dictionary App Sharing With"
                    val shareSubject = "https://play.google.com/store/apps/details?id=${com.azamovhudstc.foodapprecoginizng.BuildConfig.APPLICATION_ID.toString()}"
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareSubject)
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
                    startActivity(Intent.createChooser(sharingIntent, "Share using"))
                    my_drawer_layout.closeDrawer(GravityCompat.END)

                }
                R.id.menu_info_app ->{

                }

                R.id.menu_app_theme->{

                    val dialog = Dialog(requireContext())
                    val view: View = LayoutInflater.from(requireContext())
                        .inflate(R.layout.dialog_exit, my_drawer_layout, false)
                    dialog.setContentView(view)

                    view.findViewById<View>(R.id.button_exit_no).setOnClickListener { view1: View? ->
                        dialog.cancel()
                        dialog.dismiss()
                    }
                    view.findViewById<View>(R.id.button_exit_yes)
                        .setOnClickListener { view2: View? ->
                            dialog.cancel()
                            dialog.dismiss()
                            val a = Intent(Intent.ACTION_MAIN)
                            a.addCategory(Intent.CATEGORY_HOME)
                            a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(a)
                        }
                    dialog.show()
                    dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    my_drawer_layout.closeDrawer(GravityCompat.END)
                }

            }


            true
        }

        animateNavigationDrawer()

    }
    private fun animateNavigationDrawer() {
        my_drawer_layout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                val diffScaledOffset: Float = slideOffset * (1 - END_SCALE)
                val offsetScale = 1 - diffScaledOffset
                contentView.scaleX = offsetScale
                contentView.scaleY = offsetScale
                val xOffset = drawerView.width * slideOffset
                val xOffsetDiff: Float = contentView.width * diffScaledOffset / 2
                val xTranslation = xOffsetDiff - xOffset
                contentView.translationX = xTranslation
            }
        })
    }
    private fun appRate() {
        AppRate.with(requireActivity())
            .setInstallDays(1)
            .setLaunchTimes(3)
            .setRemindInterval(1)
            .setShowLaterButton(true)
            .setShowNeverButton(false)
            .monitor()

        AppRate.showRateDialogIfMeetsConditions(requireActivity())
    }
    private fun clickButtons(){
        btn_eng_uzb.setOnClickListener {
            viewModel.clickFoodsButton()
        }
        btn_uzb_eng.setOnClickListener {
            viewModel.clickProductsButton()

        }
    }

    private val foodsObserver=Observer<Unit>{
        var bundle=Bundle()
        bundle.putString("type","fruit_and_vegetables")
        findNavController().navigate(
            R.id.mainScreen,
            bundle,
            NavOptions.Builder().setPopUpTo(R.id.homeScreen, true).build()
        )    }
    private val productObserver=Observer<Unit>{
        var bundle=Bundle()
        bundle.putString("type","product")
        findNavController().navigate(
            R.id.mainScreen,
            bundle,
            NavOptions.Builder().setPopUpTo(R.id.homeScreen, true).build()
        )    }
}