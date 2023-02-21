package com.example.mygroceryapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GroceryItemsTable::class], version = 1, exportSchema = false)
abstract class GroceryItemsDatabase: RoomDatabase() {

    abstract fun groceryItemsDao(): GroceryItemsDao

    companion object {

        @Volatile
        private var INSTANCE: GroceryItemsDatabase? = null

        fun getDatabase(context: Context): GroceryItemsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GroceryItemsDatabase::class.java,
                    "grocery_items_database2"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }

}