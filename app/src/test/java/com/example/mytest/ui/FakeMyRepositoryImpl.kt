package com.example.mytest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mytest.db.MyEntity
import com.example.mytest.network.MyResponse
import com.example.mytest.ui.MyRepository

class FakeMyRepositoryImpl: MyRepository {

    private val entities = mutableListOf<MyEntity>()
    private val observableEntity = MutableLiveData<List<MyEntity>>()

    private fun refreshLiveData(){
        observableEntity.postValue(entities)
    }

    override suspend fun insertEntity(entity: MyEntity) {
        entities.add(entity)
        refreshLiveData()
    }

    override suspend fun deleteEntity(entity: MyEntity) {
        entities.remove(entity)
        refreshLiveData()
    }

    override fun getAllEntity(): LiveData<List<MyEntity>> {
        return observableEntity
    }

    override suspend fun userStatus(userId: Long): MyResponse {
        return MyResponse("hasan" ,"hasaniii" ,25)
    }


}