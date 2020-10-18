package com.example.neopyme.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.neopyme.R
import com.example.neopyme.db.entity.Credito
import com.example.neopyme.util.mostrarToolbar
import kotlinx.android.synthetic.main.fragment_resultado_detalle.*

class ResultadoDetalleFragment : Fragment() {

    var credito: Credito? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mostrarToolbar()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        credito = arguments?.getParcelable<Credito>("credito") as Credito

        requisitos_text.text = credito?.requisitos
        caracteristicas_text.text = credito?.caracteristicas
        beneficios_text.text = credito?.beneficios

        preaprobar_button.setOnClickListener {
            findNavController().navigate(R.id.action_resultadoDetalleFragment_to_finalFragment)
        }

    }
}