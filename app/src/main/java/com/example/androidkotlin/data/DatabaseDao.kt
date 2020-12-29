package com.example.androidkotlin.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidkotlin.data.local.models.UserLocal

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM userlocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM userlocal WHERE email LIKE :email AND password = password LIMIT 1")
    fun findByName(email: String, password:String): UserLocal?

    @Insert
    fun insert(user : UserLocal)

    @Delete
    fun delete(user: UserLocal)
}