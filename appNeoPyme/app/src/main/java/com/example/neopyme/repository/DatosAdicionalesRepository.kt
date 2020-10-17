package com.example.neopyme.repository

import com.example.neopyme.network.ApiClient
import com.example.neopyme.network.DTO.SimpleDataDTO

class DatosAdicionalesRepository {

    suspend fun getInforcorp(): List<SimpleDataDTO>{
        val response = ApiClient.serviceApi.getInfocorps()
        val resp = response.await()
        return resp
    }

    suspend fun getAnualIncomes(): List<SimpleDataDTO>{
        val response = ApiClient.serviceApi.getAnualIncomes()
        val resp = response.await()
        return resp
    }

    suspend fun getPurposesLoan(): List<SimpleDataDTO>{
        val response = ApiClient.serviceApi.getPurposesLoan()
        val resp = response.await()
        return resp
    }
}