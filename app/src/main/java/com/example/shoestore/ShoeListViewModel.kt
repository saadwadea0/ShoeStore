package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {


    private var staticList = mutableListOf<Shoe>()

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList
    var name: String = ""
    var size: String = ""
    var company: String = ""
    var description: String = ""

    init {


    }
    fun addingShoeToList(){
        if (isValid()){
            staticList.add(Shoe(name,size,company, description))
            _shoeList.value = staticList
        }

    }
    private fun isValid():Boolean{
        return !(name.isBlank() || size.isBlank() || company.isBlank() || description.isBlank())
    }

}