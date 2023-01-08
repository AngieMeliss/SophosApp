package com.example.sophosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.sophosapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //supportActionBar?.hide()   // To hide the appBar default

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        //val mToolbar : Toolbar = findViewById<Toolbar>(R.id.toolbar)

        //setSupportActionBar(binding.toolbar)
        //supportActionBar?.title = "Camilo"
        //supportActionBar?.setDisplayHomeAsUpEnabled(false)

        /*
        binding.toolbar.apply {
            setBackgroundColor(resources.getColor(R.color.white))
            setTitleTextColor(resources.getColor(R.color.white))
        }
         */

        /*
        val navController = findNavController(R.id.navigation)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
         */
    }

}