package com.example.sophosapp

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sophosapp.databinding.FragmentOfficesBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class OfficesFragment : Fragment() {

    private lateinit var _binding: FragmentOfficesBinding
    private val binding get() = _binding

    private lateinit var googleMap:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //createFragment()

            //-------------
            /*
            if (googleMap == null) {
                googleMap = (fragmentManager
                    ?.findFragmentById(R.id.mapViewOffices) as SupportMapFragment).getMap()

                // check if map is created successfully or not
                if (googleMap == null) {
                    Toast.makeText(
                        ApplicationProvider.getApplicationContext<Context>(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

            // create marker

            // create marker
            val marker = MarkerOptions().position(
                LatLng(latitude, longitude)
            ).title("Hello Maps ")

            val cameraPosition = CameraPosition.Builder()
                .target(LatLng(latitude, longitude)).zoom(15f).build()

            googleMap.animateCamera(
                CameraUpdateFactory
                    .newCameraPosition(cameraPosition)
            )

            // adding marker

            // adding marker
            googleMap.addMarker(marker)

             */
        }
    }

    /*
    private fun createFragment() {
        val mapFragment : Fragment? = fragmentManager?.findFragmentById(R.id.mapViewOffices) as SupportMapFragment
        mapFragment.getMapAsync(this)
    } */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        /* -------------------------Settings for mapa but in Java
        //initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment)
            childFragmentManager().findFragmentById(R.id.mapViewOffices)

        //Async map
        supportMapFragment.getMapAsync(new OnMapReadyCallBack(){
            @Override
            public void onMapReady(GoogleMap googleMap){
                //When map is loaded
                googleMap.setOnMapClickListener(new GoogleMap.OnMapCClickListener(){
                    @Override
                    public void onMapClick(LatLng latLng){
                        //When clicked on Map
                        //Initialize marker options
                        MarkerOptions markerOptions = new MarkerOptions()
                        markerOptions.position(latLng)
                        markerOptions.title(latLng.latitude + " : " + latLng.longitude)
                        googleMap.clear()
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            latLng, v: 10
                        ))
                        googleMap.addMarker(markerOptions)
                    }
                })
            }
        })

         */


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
