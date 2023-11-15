package com.example.exercise_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise_8.databinding.ActivityAddUserBinding

class AddUser : AppCompatActivity() {

    private lateinit var binding: ActivityAddUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        binding.btnAddUser.setOnClickListener {
            val userName = binding.etName.text.toString()
            val userLastname = binding.etLastname.text.toString()
            val userEmail = binding.etEmail.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name",userName)
            intent.putExtra("lastname",userLastname)
            intent.putExtra("email",userEmail)
            startActivity(intent)
        }
    }
}