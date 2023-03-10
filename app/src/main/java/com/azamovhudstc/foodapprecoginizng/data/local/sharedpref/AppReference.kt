package com.azamovhudstc.foodapprecoginizng.data.local.sharedpref


import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppReference @Inject  constructor(
    @ApplicationContext
    context: Context,
) {
    private var sharedPref: SharedPreferences = context.getSharedPreferences("auth", MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedPref.edit()


    fun setToken(token: String) {
        editor.putString("TOKEN", token)
        editor.apply()
    }

    fun getToken(): String? {
        return sharedPref.getString("TOKEN", "")
    }


    fun setDarkMode(token: Boolean) {
        editor.putBoolean("isDarkModeOn", token)
        editor.apply()
    }

    fun getDarkMode(): Boolean? {
        return sharedPref.getBoolean("isDarkModeOn", false)
    }

}