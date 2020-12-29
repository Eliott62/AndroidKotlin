package com.example.androidkotlin.domain.usecase

import com.example.androidkotlin.data.repository.UserRepository
import com.example.androidkotlin.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`(){
        runBlocking {
            //GIVEN
            val email = ""
            val password = ""
            coEvery { userRepository.getUser(email,password) } returns null

            //WHEN
            val result = classUnderTest.invoke(email,password)

            //THEN
            coVerify (exactly = 1) {userRepository.getUser(email,password)}
            assertEquals(result,null)
        }
    }

    @Test
    fun `invoke with valid email`(){
        runBlocking {
            //GIVEN
            val email = "a@b.c"
            val password = "abd"
            val expectedUser =  User("a@b.c","abc")
            coEvery { userRepository.getUser(email,password) } returns expectedUser

            //WHEN
            val result = classUnderTest.invoke(email,password)

            //THEN
            coVerify (exactly = 1) {userRepository.getUser(email,password)}
            assertEquals(result,expectedUser)
        }
    }
}