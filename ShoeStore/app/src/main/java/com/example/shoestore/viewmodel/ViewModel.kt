package com.example.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.shoe.ShoeModel

class ViewModel: ViewModel() {
    val name=MutableLiveData<String>()
    val company=MutableLiveData<String>()
    val size=MutableLiveData<String>()
    val description=MutableLiveData<String>()

    private val shoeList=ArrayList<ShoeModel>()
    private val _shoeData=MutableLiveData<ArrayList<ShoeModel>>()
    val shoeData:LiveData<ArrayList<ShoeModel>>
        get()=_shoeData
    fun addShoe(){
        val dataShoe=ShoeModel(name.value.toString(),company.value.toString(),size.value.toString().toInt(),description.value.toString())
        shoeList.add(dataShoe)
        _shoeData.value=shoeList
    }
    fun getAllShoe():LiveData<ArrayList<ShoeModel>>{
        return shoeData
    }
}