package com.example.neopyme.network.DTO

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
class SimpleDataDTO (
    @Json(name = "id")
    var id:  Int = 0,

    @Json(name = "text")
    var text: String? = ""

): Parcelable