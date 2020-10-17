package com.example.neopyme.network

import com.example.neopyme.network.DTO.SimpleDataDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("api/infocorps/")
    fun getInfocorps(): Deferred<List<SimpleDataDTO>>

    @GET("api/annual_incomes/")
    fun getAnualIncomes(): Deferred<List<SimpleDataDTO>>

    @GET("api/purposes/")
    fun getPurposesLoan(): Deferred<List<SimpleDataDTO>>
}