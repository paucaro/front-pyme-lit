package com.example.neopyme.repository

import com.example.neopyme.network.ApiClient
import com.example.neopyme.network.DTO.*

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

    suspend fun patchPetitioner(): Petitioner{
        val response = ApiClient.serviceApi.patchPetitioner()


        val resp = response.await()
        return resp
    }
    suspend fun  postRequest(requestInitial: RequestInitial):Request2DTO{
        val response = ApiClient.serviceApi.postRequest(requestInitial)
        val resp = response.await()
        return resp


    }
    suspend fun  patchRequest():RequestOkDTO{
        val response = ApiClient.serviceApi.patchRequest()
        val resp = response.await()
        return resp

    }
    suspend fun getProducts():List<ProductDTO>{
        val response = ApiClient.serviceApi.getProducts()
        val resp = response.await()
        return resp

    }






}