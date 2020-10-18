package com.example.neopyme.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.neopyme.network.DTO.Request2DTO
import com.example.neopyme.network.DTO.RequestInitial
import com.example.neopyme.repository.DatosAdicionalesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(aplication: Application): AndroidViewModel(aplication) {

    private val datosAdicionalesRepository = DatosAdicionalesRepository()

    fun postRequest(
        requestInitial: RequestInitial,
        onSuccess: suspend (request: Request2DTO) -> Unit,
        onFailure: suspend (e: Throwable) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                return@runCatching datosAdicionalesRepository.postRequest(requestInitial)
            }.onSuccess {
                onSuccess(it)
            }.onFailure {
                onFailure(it)
            }
        }
    }
}