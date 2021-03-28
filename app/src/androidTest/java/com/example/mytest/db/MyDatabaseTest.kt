package com.example.mytest.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mytest.getOrAwaitValueAndroid
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyDatabaseTest{

    private lateinit var db: MyDatabase
    private lateinit var dao: MyDao

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext() ,MyDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = db.getDao()
    }

    @After
    fun tearDown(){
        db.close()
    }


    @Test
    fun testInsertEntity() = runBlocking {
        // you must pass id for testing room database
        val entity = MyEntity("ali" ,"1234" ,1)
        dao.insertEntity(entity)
        val result = dao.getAllEntity().getOrAwaitValueAndroid()
        assertThat(result).contains(entity)
    }

    @Test
    fun testDeleteEntity() = runBlocking {
        // you must pass id for testing room database
        val entity = MyEntity("ali" ,"1234" ,2)
        dao.insertEntity(entity)
        dao.deleteEntity(entity)
        val result = dao.getAllEntity().getOrAwaitValueAndroid()
        assertThat(result).doesNotContain(entity)
    }

}