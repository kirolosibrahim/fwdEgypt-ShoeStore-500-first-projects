package com.udacity.shoestore.ui.welcome_screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding
import com.udacity.shoestore.ui.instruction.InstructionFragment
import com.udacity.shoestore.ui.instruction.InstructionFragmentDirections
import com.udacity.shoestore.ui.login.LoginFragmentDirections

class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome_screen,
            container,
            false
        )
        binding.lifecycleOwner = this


        binding.skipButton.setOnClickListener {
            onClickListener()
        }
        return binding.root
    }


    private fun onClickListener(){
        findNavController().navigate( WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment())
    }

}