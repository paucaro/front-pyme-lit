package com.example.neopyme.repository

import androidx.lifecycle.LiveData
import com.example.neopyme.db.dao.CreditoDao
import com.example.neopyme.db.entity.Credito
import com.example.neopyme.network.ApiClient

class ResultadosRepository (private val creditoDao: CreditoDao) {

    suspend fun getCreditos(): LiveData<List<Credito>> {
        return creditoDao.getCreditos()
    }

    fun getProductos() {

    }
}