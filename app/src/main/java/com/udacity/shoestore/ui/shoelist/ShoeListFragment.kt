package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeLayoutBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.welcome_screen.WelcomeScreenFragmentDirections


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        binding.addButton.setOnClickListener {
            findNavController().navigate( ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }


        viewModel.shoes.observe(viewLifecycleOwner, Observer {

            Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            it.forEach { shoe ->
                val itemShoeBinding: ShoeLayoutBinding = ShoeLayoutBinding.bind(
                    LayoutInflater.from(context).inflate(R.layout.shoe_layout, null)
                )
                itemShoeBinding.shoeNameTextview.text = shoe.name
                itemShoeBinding.shoeSizeTextview.text = shoe.size.toString()

                binding.listParent.addView(itemShoeBinding.root)
            }
        })
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return true
    }

}