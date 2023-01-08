package com.example.sophosapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.sophosapp.databinding.FragmentMenuScreenBinding
import com.example.sophosapp.databinding.FragmentSendDocsScreenBinding


class SendDocsScreenFragment : Fragment(R.layout.fragment_send_docs_screen) {

    private lateinit var _binding: FragmentSendDocsScreenBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSendDocsScreenBinding.inflate(inflater,container, false)

        // Inflate the layout for this fragment
        return binding.root

        //val typesID = resources.getStringArray(android.R.array.typeDocuments)

    }

    /*
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        View v = inflater.inflate(R.layout.SendDocumentsFragment, container, false)
        //val view: View = inflater.inflate(R.layout.SendDocumentsFragment, container, false)
        // To the spinner of document's type

        val spinnerTypesID = v.findViewById<Spinner>(R.id.typeDocSpinner)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, typesID)

        spinnerTypesID.adapter = arrayAdapter
        spinnerTypesID.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun OnItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ){
                Toast.makeText(applicationContext, "Selected ID is = " + typesID[position], toast.LENGHT_SHORT).show()
            }
        }
        return view
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.sophosapp.R.layout.fragment_send_documents, container, false)
    }

     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ------------------------------- Settings for Toolbar ------------------------------------
        val angie = binding.toolbarLayout
        val mToolbar = binding.toolbarLayout.toolbar
        val userName = "Regresar"
        MyToolbar().show(activity as AppCompatActivity, mToolbar, userName, true)

        setupOptionsMenu()
        mToolbar.setNavigationOnClickListener{
            findNavController().navigate(R.id.action_global_menuScreenFragment)
        }

        // ----------------------- Setting for spinner for types documents -------------------------
        val typeDocSpinner = requireView().findViewById<Spinner>(R.id.typeDocSpinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.typeDocuments,
            android.R.layout.simple_spinner_item
        ).also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            typeDocSpinner.adapter = adapter
        }

        // -----------------------  Setting for spinner for cities ---------------------------------
        val citiesSpinner = requireView().findViewById<Spinner>(R.id.citiesSpinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.cities,
            android.R.layout.simple_spinner_item
        ).also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            citiesSpinner.adapter = adapter
        }
    }

    private fun setupOptionsMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menu.clear()
                menuInflater.inflate(R.menu.contextual_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId){
                    R.id.optSendDocs -> {
                        findNavController().navigate(R.id.action_global_sendDocsScreenFragment)
                        true
                    }
                    R.id.optViewDocs -> {
                        findNavController().navigate(R.id.action_global_viewDocumentsFragment)
                        true
                    }
                    R.id.optOffices -> {
                        findNavController().navigate(R.id.action_global_officesFragment)
                        true
                    }
                    else -> false
                }
            }
        })
    }
}