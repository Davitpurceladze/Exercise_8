package com.example.exercise_8

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.exercise_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        val adapter = ListAdapter(Data.getUsers())
        binding.recyclerView.adapter = adapter

        binding.btnAddUser.setOnClickListener {
            val intent = Intent(this, AddUser::class.java)
            startActivity(intent)
        }

        val name = intent.getStringExtra("name")
        val lastname = intent.getStringExtra("lastname")
        val email = intent.getStringExtra("email")

        if(name != null && lastname != null && email != null){
            Data.run { addUser(name, lastname, email) }
            adapter.notifyItemInserted(Data.getUsers().size - 1)
        }
    }


}