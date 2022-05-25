package com.example.alarmapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alarm (
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val time : String,
    val date : String,
    val note : String,
    // TODO Add Type to Entity Database
    val type : Int
)