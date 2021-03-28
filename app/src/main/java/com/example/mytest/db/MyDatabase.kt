package com.example.mytest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyEntity::class] ,version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun getDao(): MyDao

    companion object {
        private const val DB_NAME = "MyDatabase"

        @Volatile
        private var instance: MyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }

}