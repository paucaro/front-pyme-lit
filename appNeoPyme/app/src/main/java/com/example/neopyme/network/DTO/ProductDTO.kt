package com.example.neopyme.network.DTO

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
class ProductDTO (
    @Json(name = "id")
    var id:  Int = 0,

    @Json(name = "name")
    var ruc: String? = "",

    @Json(name = "description")
    var description: List<String>? = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sábado", "domingo"),

    @Json(name = "benefits")
    var benefits: List<String>? = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sábado", "domingo"),


    @Json(name = "features")
    var features: List<String>? = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sábado", "domingo"),



    @Json(name = "requirements")
    var requirements: List<String>? = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sábado", "domingo")

): Parcelable