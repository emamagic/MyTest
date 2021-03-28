package com.example.mytest.ui

import androidx.lifecycle.LiveData
import com.example.mytest.db.MyDao
import com.example.mytest.db.MyEntity
import com.example.mytest.network.MyApi
import com.example.mytest.network.MyResponse

class MyRepositoryImpl constructor(
    private val remote: MyApi,
    private val local: MyDao
): MyRepository {

    override suspend fun insertEntity(entity: MyEntity) {
        local.insertEntity(entity)
    }

    override suspend fun deleteEntity(entity: MyEntity) {
        local.deleteEntity(entity)
    }

    override fun getAllEntity(): LiveData<List<MyEntity>> {
        return local.getAllEntity()
    }

    override suspend fun userStatus(userId: Long): MyResponse {
        return remote.userStatus(userId)
    }

}