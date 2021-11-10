package com.example.kadai

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.kadai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var sw : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sw = true

        setSupportActionBar(findViewById(R.id.toolbar))

        val naviController = findNavController(R.id.nav_host_fragment_content_main)
        setupActionBarWithNavController(naviController)

        binding.fab.setOnClickListener { view ->
            naviController.navigate(R.id.action_to_scheduleEditFragment)
        }
    }

    override fun onSupportNavigateUp()
        = findNavController(R.id.nav_host_fragment_container).navigateUp()

    fun setFabVisible(visibility:Int){
        if(sw){
            binding.fab.visibility = visibility
        }
    }
}