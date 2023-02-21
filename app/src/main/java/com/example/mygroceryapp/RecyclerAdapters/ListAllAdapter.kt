package com.example.mygroceryapp.RecyclerAdapters

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mygroceryapp.R
import com.example.mygroceryapp.data.GroceryItemsTable
import com.example.mygroceryapp.fragments.ListAllFragmentDirections

class ListAllAdapter: RecyclerView.Adapter<ListAllAdapter.MyViewHolder>()  {

    private var groceryItemsTableList = emptyList<GroceryItemsTable>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {




        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = groceryItemsTableList[position]
        holder.itemView.findViewById<TextView>(R.id.TVRecId).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.TVGroceryITem).text = currentItem.GroceryItem
        holder.itemView.findViewById<TextView>(R.id.TVHouseLocation).text =
            currentItem.HouseLocation
        holder.itemView.findViewById<TextView>(R.id.TVGroceryAisle).text = currentItem.GroceryAisle
        holder.itemView.findViewById<TextView>(R.id.TVUnitOfMeasure).text =
            currentItem.UnitOfMeasure
        holder.itemView.findViewById<TextView>(R.id.TVUnitPrice).text =
            currentItem.CurrentUnitPrice.toString()
        holder.itemView.findViewById<TextView>(R.id.TVNumberToPurchase).text =
            currentItem.QtyToPurchase.toString()
        holder.itemView.findViewById<TextView>(R.id.TVNumberInCart).text =
            currentItem.QtyInCart.toString()
        holder.itemView.findViewById<TextView>(R.id.TVBrand).text =
            currentItem.Brand.toString()
        holder.itemView.findViewById<TextView>(R.id.TVunitAmountOfMeasure).text =
            currentItem.UnitAmount.toString()

        val dbgShow = currentItem.id.toString()
        Log.d("DBG:", "dbgShow = $dbgShow")
        //Log.d("DBG:", "mSwitch = $mSwitch")

        holder.itemView.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.rowLayout)
           .setOnClickListener {
                //val action = ListAllFragmentDirections.actionListAllFragmentToAddRecordFragment()) //1
               val mSwitch = "update" //2
               val action = ListAllFragmentDirections.actionListAllFragmentToAddRecordFragment(currentItem, mSwitch) //2
                //holder.itemView.findNavController().navigate(action) //1
               holder.itemView.findNavController().navigate(directions = action) //2

               Log.d("DBG:", "dbgShow = $dbgShow")
            }
    }

    override fun getItemCount(): Int {
        return groceryItemsTableList.size
    }

    fun setData(groceryItemsTable: List<GroceryItemsTable>){
        this.groceryItemsTableList = groceryItemsTable
        notifyDataSetChanged()
    }
}
