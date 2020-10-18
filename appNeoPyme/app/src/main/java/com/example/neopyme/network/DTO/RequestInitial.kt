package com.example.neopyme.network.DTO

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
class RequestInitial (
    @Json(name = "ruc")
    var ruc:  String = "",

    @Json(name = "document_number")
    var document_number: String? = ""

): Parcelable