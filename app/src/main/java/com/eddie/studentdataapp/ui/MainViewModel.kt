package com.eddie.studentdataapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eddie.studentdataapp.api.RetrofitProvider
import com.eddie.studentdataapp.models.Item
import com.eddie.studentdataapp.models.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    val itemsLiveData = MutableLiveData<List<Item>>()
    val studentsLiveData = MutableLiveData<List<Student>>()

    fun getItems(){

        viewModelScope.launch {
            itemsLiveData.postValue(RetrofitProvider.placeHolderAPI.getItems())
        }
    }

    fun addStudent (newStudent: Student){
         CoroutineScope(Dispatchers.IO).launch {
            studentsLiveData.postValue(RetrofitProvider.placeHolderAPI.addStudent(newStudent))
        }
    }
}