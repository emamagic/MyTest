package com.example.mytest.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntity(entity: MyEntity)

    @Delete
    suspend fun deleteEntity(entity: MyEntity)


    @Query("SELECT * FROM my_entity")
    fun getAllEntity(): LiveData<List<MyEntity>>

}