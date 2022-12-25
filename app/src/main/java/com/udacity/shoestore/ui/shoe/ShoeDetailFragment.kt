package com.udacity.shoestore.ui.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.shoelist.ShoeListViewModel
import com.udacity.shoestore.ui.welcome_screen.WelcomeScreenFragmentDirections
import java.lang.Double


class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    lateinit var shoe: Shoe
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.lifecycleOwner = this



        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.saveButton.setOnClickListener {
            shoe = Shoe(
                binding.nameEditText.text.toString(),
                binding.sizeEditText.text.toString().toDouble(),
                binding.companyEditText.text.toString(),
                binding.descriptionEditText.text.toString()
            )
            viewModel.addItem(shoe)

            findNavController().navigateUp()


        }


        return binding.root
    }

}