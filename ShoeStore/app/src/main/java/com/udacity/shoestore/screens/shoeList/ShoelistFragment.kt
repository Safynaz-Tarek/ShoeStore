package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoelistBinding

class ShoelistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoelistBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoelist, container, false)

        (activity as MainActivity).supportActionBar?.title = "List"

        binding.addItemButton.setOnClickListener{view: View ->
            Navigation.findNavController(view).navigate(ShoelistFragmentDirections.actionShoelistFragmentToDetailsFragment())
        }

        return binding.root
    }

}