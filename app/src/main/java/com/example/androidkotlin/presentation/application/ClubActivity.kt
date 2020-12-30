package com.example.androidkotlin.presentation.application

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidkotlin.R
import com.example.androidkotlin.data.ApiService
import com.example.androidkotlin.domain.entity.Club
import com.example.androidkotlin.presentation.ClubsAdapter
import kotlinx.android.synthetic.main.activity_club.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Eliott62/AndroidKotlin/master/app/src/main/java/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllClubs().enqueue(object : Callback<List<Club>> {
            override fun onResponse(call: Call<List<Club>>, response: Response<List<Club>>) {
                response.body()?.let { showData(it) }
            }

            override fun onFailure(call: Call<List<Club>>, t: Throwable) {
                d("Eliott", "onFailure")
            }
        })
    }

    private fun showData(clubs: List<Club>) {
       recyclerview.apply {
            layoutManager = LinearLayoutManager(this@ClubActivity)
            adapter = ClubsAdapter(clubs)
        }
    }
}