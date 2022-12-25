package com.udacity.shoestore.ui.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {


     val shoeList = mutableListOf(
        Shoe("Nike Air", 45.0, "Nike", "Description")
    )

    fun addItem(shoe: Shoe) {

        shoeList.add(shoe)
        _shoeList.value = shoeList
    }


    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>> = _shoeList

    init {
        _shoeList.value = shoeList
    }


}