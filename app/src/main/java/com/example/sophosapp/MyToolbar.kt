package com.example.sophosapp

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MyToolbar {
    fun show(activities: AppCompatActivity, toolbar: Toolbar, title: String, upButton: Boolean){
        activities.setSupportActionBar(toolbar)
        activities.supportActionBar?.title = title
        activities.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
    }
}