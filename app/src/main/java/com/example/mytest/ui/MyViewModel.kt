package com.example.mytest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytest.db.MyEntity
import com.example.mytest.network.MyResponse
import kotlinx.coroutines.launch

class MyViewModel constructor(
    private val repository: MyRepository
): ViewModel() {

    private val _userStatus = MutableLiveData<MyResponse>()
    val userStatus: LiveData<MyResponse>
        get() = _userStatus

    fun insertEntity(entity: MyEntity) = viewModelScope.launch {
        repository.insertEntity(entity)
    }

    fun deleteEntity(entity: MyEntity) = viewModelScope.launch {
        repository.deleteEntity(entity)
    }

    fun getAllEntity() = repository.getAllEntity()


    fun userStatus(userId: Long) = viewModelScope.launch {
        _userStatus.value = repository.userStatus(userId)
    }

}