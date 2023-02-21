package com.example.mygroceryapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroceryItemsViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<GroceryItemsTable>>
    val readByHouseLocation: LiveData<List<GroceryItemsTable>>
    private val repository: GroceryItemsRepository

    init {
        val groceryItemsDao = GroceryItemsDatabase.getDatabase(application).groceryItemsDao()
        repository = GroceryItemsRepository(groceryItemsDao)
        readAllData = repository.readAllData
        readByHouseLocation = repository.readByHouseLocation

    }

    fun addGroceryItem(groceryItemsTable: GroceryItemsTable){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGroceryItem(groceryItemsTable)
        }
    }

    fun vwMdlUpdateGroceryItemsGa(groceryItemsTable: GroceryItemsTable){
        viewModelScope.launch(Dispatchers.IO) {
            repository.giUpdateYunItemaGroceria(groceryItemsTable)
        }
    }

    fun vwMdlDeletinMoGroceryItemMo(groceryItemsTable: GroceryItemsTable) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete2xDinPagMeTymItemaGroceria(groceryItemsTable)
        }
    }



}