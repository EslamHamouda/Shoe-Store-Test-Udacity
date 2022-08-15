package com.example.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.shoe.ShoeModel

class ViewModel: ViewModel() {
    private val shoeList=ArrayList<ShoeModel>()
    private val _shoeData=MutableLiveData<ArrayList<ShoeModel>>()
    val shoeData:LiveData<ArrayList<ShoeModel>>
        get()=_shoeData
    fun addShoe(shoe:ShoeModel){
        shoeList.add(shoe)
        _shoeData.value=shoeList
    }
    fun getAllShoe():LiveData<ArrayList<ShoeModel>>{
        return shoeData
    }
}