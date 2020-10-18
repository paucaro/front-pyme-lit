package com.example.neopyme.network.DTO

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
class Petitioner (
    @Json(name = "request_id")
    var request_id:  Int = 0,

    @Json(name = "phone")
    var phone: String? = "",

    @Json(name = "email")
    var email: String? = "asd",

): Parcelable