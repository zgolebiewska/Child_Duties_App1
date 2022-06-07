package com.example.mynewapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Child(
    @PrimaryKey(autoGenerate = true) val id: String = 0L.toString(),
    var name: String,
    var behaviorPoints: Int = 0,
    var dutyPoints: Int = 0,
    var drawableName: String = "",
//    var birthday: Date,
        )
