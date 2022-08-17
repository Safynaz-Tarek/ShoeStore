package com.udacity.shoestore.screens.details

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.fragment_login.view.*


class DetailsFragment : Fragment() {

    private val viewModel by activityViewModels<ActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding : FragmentDetailsBinding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_details, container, false)

        binding.activityViewModel = viewModel

        binding.cancelButton.setOnClickListener { view : View ->
            viewModel.clearFields()
            Navigation.findNavController(view).navigate(DetailsFragmentDirections.actionDetailsFragmentToShoelistFragment())
        }
        binding.saveButton.setOnClickListener { view : View->
            if(!checkEmptyFields(binding.root)) {
                viewModel.onSave()
                Navigation.findNavController(view)
                    .navigate(DetailsFragmentDirections.actionDetailsFragmentToShoelistFragment())
            }else{
                showDefaultDialog(requireContext())
            }
        }

        return binding.root
    }
    private fun showDefaultDialog(context: Context) {
        val alertDialog = AlertDialog.Builder(context)

        alertDialog.apply {
            setTitle("Warning")
            setMessage("All Fields are required, don't leave them empty")

        }.create().show()
    }
    fun checkEmptyFields(view: View) : Boolean{
        val input_shoeName = view.shoeName_editText.text.toString().trim()
        val input_shoeSize = view.shoeSize_editText.text.toString().trim()
        val input_company = view.company_editText.text.toString().trim()
        val input_description = view.description_editText.text.toString().trim()


        if(input_company.isEmpty() || input_shoeName.isEmpty() ||
                input_shoeSize.isEmpty()|| input_description.isEmpty()){
            return true
        }
        return false
    }

}