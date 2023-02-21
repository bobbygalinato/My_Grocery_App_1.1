package com.example.mygroceryapp.fragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mygroceryapp.R
import com.example.mygroceryapp.data.GroceryItemsTable
import com.example.mygroceryapp.data.GroceryItemsViewModel

class ModifyRecordFragment : Fragment() {

    private lateinit var mGroceryItemsViewModel: GroceryItemsViewModel

    //private val args by NavArgs<ModifyRecordFragmentArgs>()
    private val args by navArgs<ModifyRecordFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_modify_record, container, false)

        Log.d("DBGarguments", this.arguments.toString())
        //Log.d("DBGargs", this.args.toString())


        mGroceryItemsViewModel = ViewModelProvider(this).get(GroceryItemsViewModel::class.java)

        val mSwitch = args.mSwitch.toString()
        Log.d("DBG args-mSwitch", mSwitch)

        if (mSwitch == "update") { //===========================
            //update procedures here
            //view.findViewById<EditText>(R.id.TVRecId).setText(args.currentItem.id)
            view.findViewById<EditText>(R.id.editTextGroceryItem)
                .setText(args.currentItem!!.GroceryItem)
            view.findViewById<EditText>(R.id.editTextBrand).setText(args.currentItem!!.Brand)
            view.findViewById<EditText>(R.id.editTextUnitAmount)
                .setText(args.currentItem!!.UnitAmount.toString())
            view.findViewById<EditText>(R.id.editTextUnitPrice)
                .setText(args.currentItem!!.CurrentUnitPrice.toString())
            view.findViewById<EditText>(R.id.editTextUnitOfMeasure)
                .setText(args.currentItem!!.UnitOfMeasure)
            view.findViewById<EditText>(R.id.editTextGroceryAisleNumber)
                .setText(args.currentItem!!.GroceryAisle)
            view.findViewById<EditText>(R.id.editTextHomeStorageLocation)
                .setText(args.currentItem!!.HouseLocation)


        }


        val buttonAddModify = view.findViewById<Button>(R.id.buttonAddModify)
        buttonAddModify.setOnClickListener {
            //common tasks between add and update
            val groceryItem =
                view?.findViewById<EditText>(R.id.editTextGroceryItem)?.text.toString()
            val houseLocation =
                view?.findViewById<EditText>(R.id.editTextHomeStorageLocation)?.text.toString()
            val groceryAisle =
                requireView().findViewById<EditText>(R.id.editTextGroceryAisleNumber).text.toString()
            val unitPrice =
                view?.findViewById<EditText>(R.id.editTextUnitPrice)?.text.toString().toDouble()
            val unitOfMeasure =
                requireView().findViewById<EditText>(R.id.editTextUnitOfMeasure).text.toString()
            val brand = requireView().findViewById<EditText>(R.id.editTextBrand).text.toString()
            val unitAmount =
                requireView().findViewById<EditText>(R.id.editTextUnitAmount).text.toString()
                    .toInt()

            if (!TextUtils.isEmpty(groceryItem)) {

                if (mSwitch == "add") { //===========================
                    //add procedures here
                    //insertDataToDatabase()
                    val item = GroceryItemsTable(
                        0, groceryItem, houseLocation, 0.00,
                        0.00, groceryAisle, unitPrice, unitOfMeasure, brand, unitAmount
                    )
                    mGroceryItemsViewModel.addGroceryItem(item)
                    Toast.makeText(requireContext(), "Successfully idinagdag 6", Toast.LENGTH_LONG).show()
                    //Go back
                    findNavController().navigate(R.id.action_addRecordFragment_to_listAllFragment)
                } else {
                    if (mSwitch == "update") {
                        //update procedures here
                        val recId = args.currentItem!!.id
                        val item = GroceryItemsTable(
                            recId, groceryItem, houseLocation, 0.00,
                            0.00, groceryAisle, unitPrice, unitOfMeasure, brand, unitAmount
                        )
                        mGroceryItemsViewModel.vwMdlUpdateGroceryItemsGa(item)
                        Toast.makeText(
                            requireContext(),
                            "Successfully Updated herein 6 $groceryItem",
                            Toast.LENGTH_LONG
                        ).show()
                        //Go back
                        findNavController().navigate(R.id.action_addRecordFragment_to_listAllFragment)
                    } else {
                        // neither add nor update error
                        Toast.makeText(
                            requireContext(),
                            "ERROR: Neither Add nor Update??",
                            Toast.LENGTH_LONG
                        ).show()
                        //Go back
                        findNavController().navigate(R.id.action_addRecordFragment_to_listAllFragment)
                    }
                } //================================================
            } else {
                Toast.makeText(
                    requireContext(),
                    "Fill up at least just the Grocery Item",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        return view
    }
}

