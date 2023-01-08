package com.example.sophosapp

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.sophosapp.databinding.FragmentMenuScreenBinding
import com.example.sophosapp.databinding.FragmentSendDocsScreenBinding


class MenuScreenFragment : Fragment(R.layout.fragment_menu_screen) {

    private lateinit var _binding: FragmentMenuScreenBinding
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
        // Inflate the layout for this fragment
        _binding = FragmentMenuScreenBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ------------------------------- Settings for Toolbar ------------------------------------
        val mToolbar = binding.toolbarLayout.toolbar
        val userName = "Camilo"
        MyToolbar().show(activity as AppCompatActivity, mToolbar, userName, false)

        setupOptionsMenu()


        // ---------------------- Settings to navigate between fragments ---------------------------
        _binding.sendDocsBtn.setOnClickListener{
            findNavController().navigate(R.id.action_global_sendDocsScreenFragment)
        }
        _binding.viewDocsBtn.setOnClickListener{
            findNavController().navigate(R.id.action_global_viewDocumentsFragment)
        }
        _binding.officesBtn.setOnClickListener{
            findNavController().navigate(R.id.action_global_officesFragment)
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


    /*
    @Deprecated ("Deprecated in java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.contextual_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

     */


    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.option1){
            startActivity(Intent(requireContext(), FragmentSendDocsScreenBinding::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

     */
}

