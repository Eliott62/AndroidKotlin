package com.example.androidkotlin.data

import com.example.androidkotlin.domain.entity.Club
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api_club.json")
    fun fetchAllClubs() : Call<List<Club>>
}