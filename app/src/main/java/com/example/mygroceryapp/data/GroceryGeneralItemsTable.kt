package com.example.mygroceryapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Grocery_Items_Table")
data class GroceryItemsTable (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val GroceryItem: String,
    val HouseLocation: String,
    val QtyToPurchase: Double,
    val QtyInCart: Double,
    val GroceryAisle: String,
    val CurrentUnitPrice: Double,
    val UnitOfMeasure: String,
    val Brand: String,
    val UnitAmount: Int
    ): Parcelable