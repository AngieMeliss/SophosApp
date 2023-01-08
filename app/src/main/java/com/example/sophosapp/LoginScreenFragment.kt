package com.example.sophosapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import androidx.navigation.fragment.findNavController
import com.example.sophosapp.databinding.FragmentLoginScreenBinding
import com.example.sophosapp.databinding.FragmentMenuScreenBinding


class LoginScreenFragment : Fragment(R.layout.fragment_login_screen) {

    //private var _binding: FragmentLoginScreenBinding? = null
    //private val binding get() = _binding!!

    private lateinit var _binding: FragmentLoginScreenBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginScreenBinding.inflate(inflater,container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Settings to navigate between fragments
        _binding.loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_global_menuScreenFragment)
        }

        /* val joinBtn = requireView().findViewById<Button>(R.id.loginButton)
        val joinFingerTrcBtn = requireView().findViewById<Button>(R.id.loginButton)
        joinBtn.setOnClickListener{
            findNavController().navigate(R.id.action_loginScreenFragment_to_menuActivityFragment)
        }

         */
    }
}