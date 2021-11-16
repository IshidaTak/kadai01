package com.example.kadai

import android.media.MediaRouter
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.kadai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var sw : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)

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

    //val itemDecoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
    //recyclerView.addItemDecoration(itemDecoration)

    override fun onSupportNavigateUp()
        = findNavController(R.id.nav_host_fragment_container).navigateUp()

    fun setFabVisible(visibility:Int){
        if(sw){
            binding.fab.visibility = visibility
        }
    }
}