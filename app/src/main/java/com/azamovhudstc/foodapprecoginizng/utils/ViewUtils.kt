package com.azamovhudstc.foodapprecoginizng.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil


fun View.inVisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}


fun Fragment.showSnackbar(text: String, view: View) {
    Snackbar.make(view, text, Toast.LENGTH_SHORT).show()
}

