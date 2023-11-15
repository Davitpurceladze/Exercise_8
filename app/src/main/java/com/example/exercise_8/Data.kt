package com.example.exercise_8

object Data {
    private val users: MutableList<User> = mutableListOf()

    fun getUsers(): MutableList<User> {
        return users
    }

    fun addUser(name: String, lastname: String, email: String) {
        users.add(User(name, lastname, email))
    }

    fun deleteUser(position: Int) {
        users.removeAt(position)
    }
}