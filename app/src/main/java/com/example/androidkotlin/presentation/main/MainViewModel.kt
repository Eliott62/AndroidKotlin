package com.example.androidkotlin.presentation.main

import android.os.Build.VERSION_CODES.O
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkotlin.domain.entity.User
import com.example.androidkotlin.domain.usecase.CreateUserUseCase
import com.example.androidkotlin.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, password)
            val loginStatus = if (user != null){
                LoginSuccess(user.email, user.password)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }
}
