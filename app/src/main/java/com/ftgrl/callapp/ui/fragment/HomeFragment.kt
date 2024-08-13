package com.ftgrl.callapp.ui.fragment

import android.os.Bundle
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

class HomeFragment : Fragment(),SearchView.OnQueryTextListener{

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.fragmentHome = this


        val personList = ArrayList<Person>()
        val person1 = Person(1,"Faruk","5054660879")
        val person2 = Person(2,"Fatih","53648951321")
        val person3 = Person(3,"Furkan","1562566556")
        personList.add(person1)
        personList.add(person2)
        personList.add(person3)

        val adapter = RecyclerHomeAdapter(personList)
        binding.recyclerHomeAdapter= adapter



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







    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
    }

}