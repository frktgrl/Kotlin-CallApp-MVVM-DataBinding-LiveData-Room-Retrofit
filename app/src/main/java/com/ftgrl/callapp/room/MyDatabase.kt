package com.ftgrl.callapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ftgrl.callapp.data.entity.Person

@Database (entities = [Person::class,], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun getPersonDao () : PersonDao

}