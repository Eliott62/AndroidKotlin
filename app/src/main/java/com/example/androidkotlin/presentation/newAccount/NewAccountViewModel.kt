package com.example.androidkotlin.presentation.newAccount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkotlin.domain.entity.User
import com.example.androidkotlin.domain.usecase.CreateUserUseCase
import com.example.androidkotlin.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewAccountViewModel(
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {

    fun onClickedCreateNewAccount(email : String, password : String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (email!="" && password!="") {
                val newUser = createUserUseCase.invoke(User(email,password))
            }
        }
    }
}

