package com.example.neopyme.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neopyme.R
import com.example.neopyme.util.ocultarToolbar

class FinalFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ocultarToolbar()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_final, container, false)
    }
}