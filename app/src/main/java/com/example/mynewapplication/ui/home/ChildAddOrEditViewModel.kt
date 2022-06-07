package com.example.mynewapplication.ui.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mynewapplication.data.Child
import com.example.mynewapplication.ui.BaseViewModel
import com.example.mynewapplication.ui.SingleLiveEvent

import java.util.*

class ChildAddOrEditViewModel: BaseViewModel() {

    val showDatePickerRequest = SingleLiveEvent<Date>()
    private val _child = MutableLiveData<Child>()
    val child = _child

    override
    fun prepare(args: Bundle?){
        super.prepare(args)
        _child.value = Child(
            name = "Test", behaviorPoints = 0, dutyPoints = 0, drawableName ="",
//                            birthday = Calendar.getInstance().time
                            )
    }

    fun saveAddChildOrEdit(){
        Log.i("saveAddChildOrEdit", child.value.toString())
    }

    fun showDatePicker(){
        //child.value?.let { showDatePickerRequest.postValue(it.birthday) }

    }
}