package com.example.neopyme.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.neopyme.db.entity.Credito

@Dao
interface CreditoDao {

    @Query("SELECT * from credito_table ORDER BY id ASC")
    fun getCreditos(): LiveData<List<Credito>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCredito(credito: Credito)
}