package com.example.mytest.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mytest.MainCoroutineRule
import com.example.mytest.db.MyEntity
import com.example.mytest.getOrAwaitValue
import com.example.mytest.network.MyResponse
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MyViewModelTest{

    private lateinit var viewModel: MyViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()


    @Before
    fun setUp(){
        viewModel = MyViewModel(FakeMyRepositoryImpl())
    }

    @Test
    fun `test InsertEntity ViewModel`(){
        val entity = MyEntity("ali" ,"12345")
        viewModel.insertEntity(entity)
        val result = viewModel.getAllEntity().getOrAwaitValue()
        assertThat(result).contains(entity)
    }

    @Test
    fun `test DeleteEntity ViewModel`(){
        val entity = MyEntity("ali" ,"12345")
        viewModel.insertEntity(entity)
        viewModel.deleteEntity(entity)
        val result = viewModel.getAllEntity().getOrAwaitValue()
        assertThat(result).doesNotContain(entity)
    }

    @Test
    fun `test userStatus ViewModel`(){
        viewModel.userStatus(1)
        val result = viewModel.userStatus.getOrAwaitValue()
        assertThat(result).isEqualTo(MyResponse("hasan" ,"hasaniii" ,25))
    }

}