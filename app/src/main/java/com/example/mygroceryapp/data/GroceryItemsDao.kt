package com.example.mygroceryapp.data

import android.content.ClipData.Item
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GroceryItemsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGroceryItem(grocery_item: GroceryItemsTable)

    @Query("SELECT * FROM Grocery_Items_Table ORDER BY id ASC")
    fun readAllData(): LiveData<List<GroceryItemsTable>>

    @Query("SELECT * FROM Grocery_Items_Table ORDER BY HouseLocation ASC")
    fun readByHouseLocation(): LiveData<List<GroceryItemsTable>>

    @Update
    suspend fun iyaUpdateAngData(grocery_item: GroceryItemsTable)

    @Delete
    suspend fun giDeleteAmayDataRecord(grocery_item: GroceryItemsTable)


}