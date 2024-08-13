package com.ftgrl.callapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ftgrl.callapp.data.entity.Person
import com.ftgrl.callapp.data.repository.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (val repo : PersonDaoRepository): ViewModel() {

    var personsList = MutableLiveData<List<Person>>()

    init{
        uploadPerson()
        personsList = repo.uploadPerson()
    }

    fun search (searchWord : String) {

        repo.searchPerson(searchWord)
    }
    fun personDelete(id : Int) {

        repo.personDelete(id)
    }
    fun uploadPerson () {

        repo.getAllPerson()

    }
}