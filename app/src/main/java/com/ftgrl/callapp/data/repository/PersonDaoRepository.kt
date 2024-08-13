package com.ftgrl.callapp.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ftgrl.callapp.data.entity.Person

class PersonDaoRepository {

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

        val personList = ArrayList<Person>()
        val person1 = Person(1,"Faruk","5054660879")
        val person2 = Person(2,"Fatih","53648951321")
        val person3 = Person(3,"Furkan","1562566556")
        personList.add(person1)
        personList.add(person2)
        personList.add(person3)

        personsList.value = personList
    }

    fun uploadPerson() : MutableLiveData<List<Person>> {

        return personsList
    }

}