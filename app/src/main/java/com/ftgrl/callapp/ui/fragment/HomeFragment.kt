package com.ftgrl.callapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.ftgrl.callapp.R
import com.ftgrl.callapp.adapter.RecyclerHomeAdapter
import com.ftgrl.callapp.data.entity.Person
import com.ftgrl.callapp.databinding.FragmentHomeBinding
import com.ftgrl.callapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(),SearchView.OnQueryTextListener{

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.fragmentHome = this


        viewModel.personsList.observe(viewLifecycleOwner){

            val adapter = RecyclerHomeAdapter(it,viewModel)
            binding.recyclerHomeAdapter= adapter
        }





        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar) //toolbarın toolbar oldugunu bildirmek

        requireActivity().addMenuProvider(object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.app_menu,menu)

                val item = menu.findItem(R.id.searchButton)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }


        },viewLifecycleOwner,Lifecycle.State.RESUMED)



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }



    fun addButtonClicked (it: View) {

        Navigation.findNavController(it).navigate(R.id.saveFragmentAction)

    }







    override fun onQueryTextSubmit(query: String): Boolean {

        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        Log.e("Anasayfa Dönüldü","Dönüldü")
    }

}