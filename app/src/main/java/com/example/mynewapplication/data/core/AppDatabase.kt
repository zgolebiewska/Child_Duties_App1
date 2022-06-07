package com.example.mynewapplication.data.core;

import androidx.room.Database;
import androidx.room.RoomDatabase
import androidx.room.TypeConverters;
import com.example.mynewapplication.data.Child
import com.example.mynewapplication.data.ChildDao

@Database(
    entities = [Child::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun childDao() : ChildDao
}


