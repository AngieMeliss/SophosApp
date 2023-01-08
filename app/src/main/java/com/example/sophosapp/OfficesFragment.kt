package com.example.sophosapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.sophosapp.databinding.FragmentOfficesBinding
import com.example.sophosapp.databinding.FragmentSendDocsScreenBinding

class OfficesFragment : Fragment() {

    private lateinit var _binding: FragmentOfficesBinding
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
        _binding = FragmentOfficesBinding.inflate(inflater,container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ------------------------------- Settings for Toolbar ------------------------------------
        val mToolbar = binding.toolbarLayout.toolbar
        val userName = "Regresar"
        MyToolbar().show(activity as AppCompatActivity, mToolbar, userName, true)

        setupOptionsMenu()
        mToolbar.setNavigationOnClickListener{
            findNavController().navigate(R.id.action_global_menuScreenFragment)
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
