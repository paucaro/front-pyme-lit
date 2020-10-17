package com.example.neopyme.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "credito_table")
@Parcelize
data class Credito (
    @PrimaryKey()
    val id: Int = 0,

    @ColumnInfo(name = "nombre")
    var nombre: String = "",

    @ColumnInfo(name = "descripcion")
    var descripcion: String = "",

    @ColumnInfo(name = "beneficios")
    var beneficios: String = "",

    @ColumnInfo(name = "caracteristicas")
    var caracteristicas: String = "",

    @ColumnInfo(name = "requisitos")
    var requisitos: String = ""

): Parcelable