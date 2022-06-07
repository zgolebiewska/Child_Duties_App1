package com.example.mynewapplication.data.core;

import android.content.Context;

import androidx.room.Room;

import com.example.mynewapplication.data.ChildDao;
import com.example.mynewapplication.data.core.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    fun provideAppDatabase(@ApplicationContext context: Context) {
        Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,"child_database"
        )

    }
    @Provides
    @Singleton
    fun provideChildDao(database: AppDatabase): ChildDao = database.childDao()
}
