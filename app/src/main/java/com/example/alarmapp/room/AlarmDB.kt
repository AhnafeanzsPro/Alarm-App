package com.example.alarmapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Alarm::class],
    // TODO Update version of Database after change Entity
    version = 2
)

abstract class AlarmDB : RoomDatabase() {
    abstract fun alarmDao(): AlarmDao

    companion object {
        @Volatile
        private var instance: AlarmDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AlarmDB::class.java, "alarm12345.db")
                    // TODO Add method fallbackToDestructiveMigration() after change Database's Entities
                .fallbackToDestructiveMigration()
                .build()
    }
}