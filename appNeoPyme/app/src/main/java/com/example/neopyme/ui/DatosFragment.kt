package com.example.neopyme.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.neopyme.R
import com.example.neopyme.adapter.DataCustom
import com.example.neopyme.network.DTO.SimpleDataDTO
import com.example.neopyme.util.disableSpinner
import com.example.neopyme.util.enableSpinner
import com.example.neopyme.util.ocultarToolbar
import com.example.neopyme.viewmodel.DatosViewModel
import kotlinx.android.synthetic.main.fragment_datos.*


class DatosFragment : Fragment() {

    private lateinit var viewModel: DatosViewModel
    var sel = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        ocultarToolbar()

        viewModel = ViewModelProvider(this).get(DatosViewModel::class.java)

        return inflater.inflate(R.layout.fragment_datos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataRangoDeudaCustom = DataCustom(requireContext())
        val dataFacturacionCustom = DataCustom(requireContext())
        val dataLoanCustom = DataCustom(requireContext())
        rango_deuda_spinner.adapter = dataRangoDeudaCustom
        facturacion_anual_spinner.adapter = dataFacturacionCustom
        motivo_prestamo_spinner.adapter = dataLoanCustom

        enableSpinner()
        viewModel.getInfocorp({
            activity?.runOnUiThread {
                dataRangoDeudaCustom.setDataset(it)
                disableSpinner()
            }
        }, {
            Log.e("ERROR", "Infocorp data - $it")
            disableSpinner()
        })

        viewModel.getAnualIncomes({
            activity?.runOnUiThread {
                dataFacturacionCustom.setDataset(it)
                disableSpinner()
            }
        }, {
            Log.e("ERROR", "Infocorp data - $it")
            disableSpinner()
        })

        viewModel.getPurposesLoan({
            activity?.runOnUiThread {
                dataLoanCustom.setDataset(it)
                disableSpinner()
            }
        }, {
            Log.e("ERROR", "Infocorp data - $it")
            disableSpinner()
        })

        evaluar_button.setOnClickListener {
            var rangoSelected = rango_deuda_spinner.selectedItem as SimpleDataDTO
            Log.e("AQUI", "selected: ${rangoSelected.id} ${rangoSelected.text}")
            findNavController().navigate(R.id.action_datosFragment_to_resultadosFragment)
        }
    }

}