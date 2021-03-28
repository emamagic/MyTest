package com.example.mytest.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_entity")
data class MyEntity(
    val name: String? = null,
    val password: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)