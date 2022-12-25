package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.lifecycleOwner = this



        binding.loginButton.setOnClickListener {
            onClickListener()
        }
        binding.registerButton.setOnClickListener {
            onClickListener()
        }


        return binding.root
    }

    fun onClickListener() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment())
    }

}