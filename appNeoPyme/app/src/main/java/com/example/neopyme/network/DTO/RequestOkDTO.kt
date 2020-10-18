package com.example.neopyme.network.DTO

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
class RequestOkDTO (
    @Json(name = "ok")
    var ok:  Int = 0,


): Parcelable