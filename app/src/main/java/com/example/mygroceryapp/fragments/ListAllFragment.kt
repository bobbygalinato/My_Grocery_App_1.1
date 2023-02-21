package com.example.mygroceryapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygroceryapp.R
import com.example.mygroceryapp.RecyclerAdapters.ListAllAdapter
import com.example.mygroceryapp.data.GroceryItemsTable
import com.example.mygroceryapp.data.GroceryItemsViewModel


class ListAllFragment : Fragment() {

    private lateinit var mGroceryItemsViewModel: GroceryItemsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_all, container, false)

         /*val floatingActionButton = view.findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listAllFragment_to_addRecordFragment)
        }
        */

        //RecyclerView
        val adapter = ListAllAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.ListAllRecycler)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //User ViewModel
        mGroceryItemsViewModel = ViewModelProvider(this).get(GroceryItemsViewModel::class.java)
        mGroceryItemsViewModel.readAllData.observe(viewLifecycleOwner, Observer { groceryItemsTable ->
            adapter.setData(groceryItemsTable)
        })


        val addButton = view.findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatingActionButton)
        addButton.setOnClickListener {
            val mSwitch = "add"
            //findNavController().navigate(R.id.action_listAllFragment_to_addRecordFragment) //1
            findNavController().navigate(directions = ListAllFragmentDirections.actionListAllFragmentToAddRecordFragment(null, mSwitch)) //2

            /*val dbgShow = currentItem.id.toString() // to delete
            Log.d("DBG:", "dbgShow = $dbgShow")*/  // to delete
            Log.d("DBG:", "mSwitch = $mSwitch")

        }
        return view

    }


}