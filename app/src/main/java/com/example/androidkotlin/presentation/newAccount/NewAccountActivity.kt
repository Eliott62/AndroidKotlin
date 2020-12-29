package com.example.androidkotlin.presentation.newAccount

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_new_account.*
import org.koin.android.ext.android.inject


class NewAccountActivity : AppCompatActivity() {
    private val newAccountViewModel: NewAccountViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)

        create_new_account_button.setOnClickListener{
            newAccountViewModel.onClickedCreateNewAccount(
                new_login_edit.text.toString().trim(),
                new_password_edit.text.toString()
            )
            MaterialAlertDialogBuilder(this)
                .setTitle("Félicitations")
                .setMessage("Compte crée")
                .setPositiveButton("Ok") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}
