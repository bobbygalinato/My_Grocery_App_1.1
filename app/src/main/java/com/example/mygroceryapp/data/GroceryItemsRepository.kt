package com.example.mygroceryapp.data

import androidx.lifecycle.LiveData

class GroceryItemsRepository(private val groceryItemsDao: GroceryItemsDao) {

    val readAllData: LiveData<List<GroceryItemsTable>> = groceryItemsDao.readAllData()

    val readByHouseLocation: LiveData<List<GroceryItemsTable>> = groceryItemsDao.readByHouseLocation()

    suspend fun addGroceryItem(groceryItemsTable: GroceryItemsTable){
        groceryItemsDao.addGroceryItem(groceryItemsTable)
    }

    suspend fun giUpdateYunItemaGroceria(groceryItemsTable: GroceryItemsTable){
        groceryItemsDao.iyaUpdateAngData(groceryItemsTable)
    }

    suspend fun delete2xDinPagMeTymItemaGroceria(groceryItemsTable: GroceryItemsTable){
        groceryItemsDao.giDeleteAmayDataRecord(groceryItemsTable)
    }

}
