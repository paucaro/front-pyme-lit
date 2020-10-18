package com.example.neopyme.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.neopyme.R
import com.example.neopyme.network.DTO.RequestInitial
import com.example.neopyme.repository.DatosAdicionalesRepository
import com.example.neopyme.util.disableSpinner
import com.example.neopyme.util.enableSpinner
import com.example.neopyme.util.ocultarToolbar
import com.example.neopyme.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.regex.Pattern

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

            val dni = dni.text.toString()
            val ruc = ruc.text.toString()

            enableSpinner()
            if (dni.isNotEmpty() && ruc.isNotEmpty()) {
                if (Pattern.compile("^[0-9]{8}").matcher(dni).matches() &&
                    Pattern.compile("^[0-9]{11}").matcher(ruc).matches()) {
                    viewModel.postRequest(
                        RequestInitial(ruc, dni),
                        {
                            activity?.runOnUiThread {
                                if (it.internalClient!!)
                                    findNavController().navigate(R.id.action_mainFragment_to_datosFragment)
                                else
                                    findNavController().navigate(R.id.action_mainFragment_to_resultadosFragment)
                                disableSpinner()
                            }
                        }, {
                            activity?.runOnUiThread {
                                Snackbar.make(
                                    view,
                                    "No se pudo realizar su consulta.\nAsegúrese de ingresar datos válidos",
                                    Snackbar.LENGTH_LONG
                                ).show()
                                disableSpinner()
                            }
                        }
                    )
                } else {
                    Snackbar.make(
                        view,
                        "Ingrese información válida",
                        Snackbar.LENGTH_LONG
                    ).show()
                    disableSpinner()
                }
            } else {
                Snackbar.make(
                    view,
                    "Complete todos los campos",
                    Snackbar.LENGTH_LONG
                ).show()
                disableSpinner()
            }
            /*GlobalScope.launch  {

                if(datosAdicionalesRepository.postRequest(ruc.text.toString(),
                        dni.text.toString() ).internalClient!! )

            }*/
        }

    }

}