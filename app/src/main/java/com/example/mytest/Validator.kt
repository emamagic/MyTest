package com.example.mytest

object Validator {

    /**
     * @param name ->
     * it should not be empty ,
     * it is only contain word
     * @param password ->
     * it should not be empty ,
     * it is only contain digit ,
     * it should be more thane 3 digit
     * @return Boolean ->
     * it indicate that input is valid or not
     * */
    fun validateInput(name: String ,password: String): Boolean{
        if(name.isNotEmpty() && password.isNotEmpty() && password.length > 3){
            name.forEach { if (it.isDigit()) return false }
            password.forEach { if (!it.isDigit()) return false }
            return true
        }
        return false
    }

}