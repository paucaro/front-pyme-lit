package com.example.neopyme.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.neopyme.R
import com.example.neopyme.repository.DatosAdicionalesRepository
import com.example.neopyme.util.ocultarToolbar
import com.example.neopyme.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val datosAdicionalesRepository = DatosAdicionalesRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ocultarToolbar()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preevaluar_button.setOnClickListener {
            GlobalScope.launch  {

                if(true||datosAdicionalesRepository.postRequest(ruc.text.toString(),
                        dni.text.toString() ).internalClient!! )
                findNavController().navigate(R.id.action_mainFragment_to_datosFragment)
            }
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}