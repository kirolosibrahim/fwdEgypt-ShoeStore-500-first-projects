package com.udacity.shoestore.ui.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.ui.login.LoginFragmentDirections


class InstructionFragment :  Fragment() {

    private lateinit var binding: FragmentInstructionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instruction,
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

        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
    }

}