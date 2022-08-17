package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_login,container, false)

        binding.loginButtonExisting.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        binding.signUpButton.setOnClickListener { view :View ->
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }

}