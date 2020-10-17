package com.example.neopyme.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.neopyme.db.NeoRoomDatabase
import com.example.neopyme.db.entity.Credito
import com.example.neopyme.repository.ResultadosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultadosViewModel(aplication: Application): AndroidViewModel(aplication) {
    private val resultadosRepository: ResultadosRepository

    init {
        val creditoDao = NeoRoomDatabase.getDatabase(aplication, viewModelScope).creditoDao()
        resultadosRepository = ResultadosRepository(creditoDao)
    }

    fun getCreditos(
        onSuccess: suspend (categorias: LiveData<List<Credito>>) -> Unit,
        onFailure: suspend (e: Throwable) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                return@runCatching resultadosRepository.getCreditos()
            }.onSuccess {
                onSuccess(it)
            }.onFailure {
                onFailure(it)
            }
        }
    }
}