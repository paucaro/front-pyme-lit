package com.example.neopyme.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.neopyme.db.dao.CreditoDao
import com.example.neopyme.db.entity.Credito
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        Credito::class
    ],
    version = 1,
    exportSchema = false
)

public abstract class NeoRoomDatabase: RoomDatabase() {

    abstract fun creditoDao(): CreditoDao

    companion object {

        @Volatile
        private var INSTANCE: NeoRoomDatabase? = null

        fun getDatabase(

            context: Context,
            scope: CoroutineScope

        ): NeoRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NeoRoomDatabase::class.java,
                    "neo_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabaseCredito(database.creditoDao())
                    }
                }
            }
        }

        suspend fun populateDatabaseCredito(creditoDao: CreditoDao) {
            creditoDao.insertCredito(
                Credito(
                1, "Tarjeta de Capital de Trabajo",
                    "-Recibe hasta 200,000 soles\n" +
                            "-Financia tus consumos y retiros hasta en 24 meses\n" +
                            "-Retira tu dinero en cualquier cajero, ventanilla y/o Agente Express"
                )
            )
            creditoDao.insertCredito(
                Credito(
                    2, "Tarjeta de Capital de Trabajo",
                    "-Recibe hasta 200,000 soles\n" +
                            "-Financia tus consumos y retiros hasta en 24 meses\n" +
                            "-Retira tu dinero en cualquier cajero, ventanilla y/o Agente Express"
                )
            )
        }
    }
}