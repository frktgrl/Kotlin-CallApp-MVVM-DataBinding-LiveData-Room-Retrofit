package com.ftgrl.callapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ftgrl.callapp.data.repository.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor (val repo : PersonDaoRepository): ViewModel()  {


    fun updatePerson (id : Int ,name : String , number : String){

        repo.updatePerson(id,name,number)
    }
}