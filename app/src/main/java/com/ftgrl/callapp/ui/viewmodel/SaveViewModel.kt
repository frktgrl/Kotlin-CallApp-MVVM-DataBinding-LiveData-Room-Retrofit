package com.ftgrl.callapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ftgrl.callapp.data.repository.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SaveViewModel @Inject constructor (val repo : PersonDaoRepository): ViewModel()  {



    fun savePerson (name : String , number : String){

        repo.savePerson(name,number)
    }
}