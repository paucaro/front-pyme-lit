package com.example.neopyme.util

import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.neopyme.R
import com.example.neopyme.activity.MainActivity

fun Fragment.ocultarToolbar() {
    if (activity is MainActivity) {
        activity!!.findViewById<Toolbar>(R.id.toolbar_main).visibility =
            View.GONE
    }
}

fun Fragment.mostrarToolbar() {
    if (activity is MainActivity) {
        activity!!.findViewById<Toolbar>(R.id.toolbar_main).visibility =
            View.VISIBLE
    }
}

fun Fragment.enableSpinner() {
    activity?.findViewById<ConstraintLayout>(R.id.progress_bar)?.visibility =
        View.VISIBLE
    activity?.window?.setFlags(
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
    )
}

fun Fragment.disableSpinner() {
    activity?.runOnUiThread {
        activity?.findViewById<ConstraintLayout>(R.id.progress_bar)?.visibility =
            View.GONE
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
}
