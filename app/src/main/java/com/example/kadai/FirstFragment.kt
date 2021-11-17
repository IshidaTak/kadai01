package com.example.kadai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kadai.databinding.FragmentFirstBinding
import io.realm.Realm
import io.realm.kotlin.where

class FirstFragment : Fragment() {

    //val separateLine = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

    //RecyclerView.addItemDecoration(separateLine)

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {

        //val separateLine = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        //RecyclerView.addItemDecoration(separateLine)

        super.onCreate(savedInstanceState)
        realm = Realm.getDefaultInstance()
        //val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)
        //addItemDecoration(dividerItemDecoration)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.list.layoutManager = LinearLayoutManager(context)
        val schedules = realm.where<Schedule>().findAll()
        val adapter = ScheduleAdapter(schedules)
        binding.list.adapter = adapter
        //addItemDecoration(dividerItemDecoration)

        adapter.setOnItemClickListener { id ->
            id?.let {
                val action =
                    FirstFragmentDirections.actionToScheduleEditFragment(it)
                findNavController().navigate(action)
                //addItemDecoration(dividerItemDecoration)
            }
        }
        (activity as? MainActivity)?.setFabVisible(View.VISIBLE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}