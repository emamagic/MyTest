package com.example.mytest.ui

import androidx.lifecycle.LiveData
import com.example.mytest.db.MyEntity
import com.example.mytest.network.MyResponse

interface MyRepository {

    suspend fun insertEntity(entity: MyEntity)

    suspend fun deleteEntity(entity: MyEntity)

    fun getAllEntity(): LiveData<List<MyEntity>>

    suspend fun userStatus(userId: Long): MyResponse

}