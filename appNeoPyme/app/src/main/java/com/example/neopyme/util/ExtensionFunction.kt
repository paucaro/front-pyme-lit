package com.example.neopyme.util

import android.view.View
import androidx.appcompat.widget.Toolbar
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