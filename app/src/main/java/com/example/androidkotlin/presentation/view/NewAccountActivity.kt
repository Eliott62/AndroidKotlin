package com.example.androidkotlin.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_new_account.*


class NewAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)

        create_new_account_button.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Félicitations")
                .setMessage("Compte crée")
                .setPositiveButton("Ok") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}