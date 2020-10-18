package com.example.neopyme.network.DTO

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
class Request2DTO (
    @Json(name = "id")
    var id:  Int = 0,

    @Json(name = "ruc")
    var ruc: String? = "",

    @Json(name = "documentNumber")
    var documentNumber: String? = "1",


    @Json(name = "internalClient")
    var internalClient: Boolean? = true
): Parcelable