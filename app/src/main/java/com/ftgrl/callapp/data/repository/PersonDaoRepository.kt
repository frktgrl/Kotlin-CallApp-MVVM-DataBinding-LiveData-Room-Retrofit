package com.ftgrl.callapp.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ftgrl.callapp.data.entity.Person
import com.ftgrl.callapp.room.PersonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonDaoRepository (var dao : PersonDao){

    val personsList:MutableLiveData<List<Person>>

    init {
        personsList = MutableLiveData()
    }


    fun savePerson (name : String , number : String){

        Log.e("name","$name - $number")

    }

    fun updatePerson(id : Int,name : String,number : String) {

        Log.e("name + number + id","$name + $number + $id")
    }

    fun searchPerson(searchWord : String) {

        Log.e("Word: ","$searchWord")
    }

    fun personDelete(id : Int) {

        Log.e("Person Delete",id.toString())
    }

    fun getAllPerson() {

       val job = CoroutineScope(Dispatchers.Main).launch {

           personsList.value = dao.getAllPerson()
       }
    }

    fun uploadPerson() : MutableLiveData<List<Person>> {

        return personsList
    }

}