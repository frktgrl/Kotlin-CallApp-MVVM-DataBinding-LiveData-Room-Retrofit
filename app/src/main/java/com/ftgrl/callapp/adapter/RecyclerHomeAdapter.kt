package com.ftgrl.callapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ftgrl.callapp.R
import com.ftgrl.callapp.data.entity.Person
import com.ftgrl.callapp.databinding.RecyclerRowHomeBinding
import com.ftgrl.callapp.ui.fragment.HomeFragmentDirections
import com.ftgrl.callapp.ui.viewmodel.HomeViewModel
import com.google.android.material.snackbar.Snackbar

class RecyclerHomeAdapter(private val personList: List<Person>, var viewModel: HomeViewModel) : RecyclerView.Adapter<RecyclerHomeAdapter.RowHolder>() {

    class RowHolder(val binding : RecyclerRowHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val itemBinding:RecyclerRowHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.recycler_row_home ,parent, false)
        return RowHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        val person = personList[position]
        val t = holder.binding

        t.personEntity = person

        holder.binding.deleteView.setOnClickListener {

            Snackbar.make(it,"${person.name}  Delete ?",Snackbar.LENGTH_LONG)
                .setAction("YES"){

                    viewModel.personDelete(person.id)
                }.show()
        }


        holder.binding.personCard.setOnClickListener {

            val action= HomeFragmentDirections.infoFragmentAction(person = person)
            Navigation.findNavController(it).navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return personList.size
    }
}
