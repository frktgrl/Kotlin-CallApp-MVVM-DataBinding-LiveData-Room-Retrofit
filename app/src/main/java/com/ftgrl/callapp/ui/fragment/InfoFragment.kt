package com.ftgrl.callapp.ui.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ftgrl.callapp.R
import com.ftgrl.callapp.databinding.FragmentInfoBinding
import com.ftgrl.callapp.ui.viewmodel.InfoViewModel
import com.ftgrl.callapp.ui.viewmodel.SaveViewModel

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel: InfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_info,container,false)
        binding.fragmentInfo = this

        val bundle:InfoFragmentArgs by navArgs()
        val bundlePerson = bundle.person

        binding.personEntity = bundlePerson

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : InfoViewModel by viewModels()
        viewModel = tempViewModel
    }




    fun updateButton (id : Int? , name: String, number : String) {

        Log.e("name + number", "$name + $number +$id")


    }


}