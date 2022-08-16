package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var viewModel: ActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding : FragmentDetailsBinding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_details, container, false)

        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        binding.activityViewModel = viewModel


//        (activity as MainActivity).supportActionBar?.title = "Details"

        binding.cancelButton.setOnClickListener { view : View ->
            Navigation.findNavController(view).navigate(DetailsFragmentDirections.actionDetailsFragmentToShoelistFragment())
        }

        return binding.root
    }

}