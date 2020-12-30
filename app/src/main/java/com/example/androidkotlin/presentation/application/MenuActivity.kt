package com.example.androidkotlin.presentation.application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlin.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        classement_button.setOnClickListener {
            startActivity(Intent(this, ClassementActivity::class.java))
        }

        club_button.setOnClickListener {
            startActivity(Intent(this, ClubActivity::class.java))
        }
    }
}