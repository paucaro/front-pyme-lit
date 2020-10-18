package com.example.neopyme.network

import com.example.neopyme.network.DTO.*
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface Service {

    @GET("api/infocorps/")
    fun getInfocorps(): Deferred<List<SimpleDataDTO>>

    @GET("api/annual_incomes/")
    fun getAnualIncomes(): Deferred<List<SimpleDataDTO>>

    @GET("api/purposes/")
    fun getPurposesLoan(): Deferred<List<SimpleDataDTO>>

    @POST("api/request/")
    fun postRequest(@Body body:RequestInitial): Deferred<Request2DTO>

    @PATCH("api/request/")
    fun patchRequest(): Deferred<RequestOkDTO>

    @PATCH(
            "/api/request/petitioner")
    fun patchPetitioner(): Deferred<Petitioner>


    @GET("api/products/")
    fun getProducts( ): Deferred<List<ProductDTO>>


}