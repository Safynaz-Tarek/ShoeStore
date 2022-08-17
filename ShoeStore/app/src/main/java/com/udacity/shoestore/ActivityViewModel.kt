package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ActivityViewModel: ViewModel(){

    private var _shoeList: MutableLiveData<MutableList<Shoe>> = MutableLiveData(ArrayList())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    var index = -1

    var shoeName = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var shoeSize = MutableLiveData<String>()
    var description = MutableLiveData<String>()

    init{
        Log.i("INITAA","Im in")

    }
    fun onSave(){
        val newShoe = Shoe(shoeName.value.toString()?: "Empty",
            shoeSize.value?.toDouble() ?: 0.0 ,
            company.value.toString()?: "Empty" ,
            description.value.toString()?: "Empty")

        index += 1
        addNewItem(newShoe)
        clearFields()
    }

     fun clearFields() {
        shoeName.value = ""
        company.value = ""
        shoeSize.value = ""
        description.value = ""

    }

    fun addNewItem(newItem : Shoe){

        _shoeList.value?.add(newItem)
        _shoeList.value = _shoeList.value




        Log.i("ShoeList", "Shoe Size, ${_shoeList.value?.get(0)?.name}")
        Log.i("ViewModel", "ShoeName ,${shoeName.value}")
    }


}