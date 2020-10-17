package com.example.neopyme.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.neopyme.R
import com.example.neopyme.adapter.ResultadosAdapter
import com.example.neopyme.util.mostrarToolbar
import com.example.neopyme.viewmodel.ResultadosViewModel
import kotlinx.android.synthetic.main.fragment_resultados.*

class ResultadosFragment : Fragment() {

    private lateinit var resultadosViewModel: ResultadosViewModel
    lateinit var adapter: ResultadosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = ResultadosAdapter(requireContext())
        mostrarToolbar()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultados, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mensaje_creditos.text = "Hola Yuliana Apaza! Tenemos estos créditos para tí"

        recycler_creditos.adapter = adapter
        recycler_creditos.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        resultadosViewModel = ViewModelProvider(this).get(ResultadosViewModel::class.java)
        resultadosViewModel.getCreditos({
            activity?.runOnUiThread {
            it.observe(viewLifecycleOwner, Observer {
                c -> adapter.setCreditos(c)
            })
            }
        }, {})
    }
}