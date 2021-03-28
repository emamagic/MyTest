package com.example.mytest

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun `name is empty return false`(){
        val name = ""
        val password = "1234"
        val result = Validator.validateInput(name ,password)
        assertThat(result).isFalse()
    }

    @Test
    fun `name contain digit return false`(){
        val name = "ali1"
        val password = "1234"
        val result = Validator.validateInput(name ,password)
        assertThat(result).isFalse()
    }

    @Test
    fun `password is empty return false`(){
        val name = "ali"
        val password = ""
        val result = Validator.validateInput(name ,password)
        assertThat(result).isFalse()
    }


    @Test
    fun `password contain word return false`(){
        val name = "ali"
        val password = "1234a"
        val result = Validator.validateInput(name ,password)
        assertThat(result).isFalse()
    }

    @Test
    fun `password is less thane 3 digit retutn false`(){
        val name = "ali"
        val password = "12"
        val result = Validator.validateInput(name ,password)
        assertThat(result).isFalse()
    }


    @Test
    fun `name and pass are correct return true`(){
        val name = "ali"
        val password = "1234"
        val result = Validator.validateInput(name ,password)
        assertThat(result).isTrue()
    }


}