package com.ftgrl.callapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Person")
data class Person (

    @ColumnInfo("id")
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo("name")
    var name: String,

    @ColumnInfo("number")
    var number: String) : Serializable {


}