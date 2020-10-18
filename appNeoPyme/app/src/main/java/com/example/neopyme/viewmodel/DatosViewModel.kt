package com.example.neopyme.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.neopyme.network.DTO.SimpleDataDTO
import com.example.neopyme.repository.DatosAdicionalesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatosViewModel(aplication: Application): AndroidViewModel(aplication) {

    private val datosAdicionalesRepository = DatosAdicionalesRepository()

    fun getInfocorp(
        onSuccess: suspend (infocorp: List<SimpleDataDTO>) -> Unit,
        onFailure: suspend (e: Throwable) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                return@runCatching datosAdicionalesRepository.getInforcorp()
            }.onSuccess {
                onSuccess(it)
            }.onFailure {
                onFailure(it)
            }
        }
    }

    fun getAnualIncomes(
        onSuccess: suspend (anualIncomes: List<SimpleDataDTO>) -> Unit,
        onFailure: suspend (e: Throwable) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                return@runCatching datosAdicionalesRepository.getAnualIncomes()
            }.onSuccess {
                onSuccess(it)
            }.onFailure {
                onFailure(it)
            }
        }
    }

    fun getPurposesLoan(
        onSuccess: suspend (purposesLoan: List<SimpleDataDTO>) -> Unit,
        onFailure: suspend (e: Throwable) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                return@runCatching datosAdicionalesRepository.getPurposesLoan()
            }.onSuccess {
                onSuccess(it)
            }.onFailure {
                onFailure(it)
            }
        }
    }
}