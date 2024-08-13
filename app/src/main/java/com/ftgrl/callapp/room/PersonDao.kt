package com.ftgrl.callapp.room

import androidx.room.Dao
import androidx.room.Query
import com.ftgrl.callapp.data.entity.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM Person")
    suspend fun getAllPerson(): List<Person>
}