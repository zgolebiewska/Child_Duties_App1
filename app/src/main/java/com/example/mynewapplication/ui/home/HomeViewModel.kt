package com.example.mynewapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynewapplication.data.Child
import com.example.mynewapplication.ui.BaseViewModel
import com.example.mynewapplication.ui.NavigationCommand


class HomeViewModel : BaseViewModel() {

    private val _childList = MutableLiveData<List<Child>>()
    val childList : LiveData<List<Child>> = _childList

    init{
        fetchChildList()
    }

    private fun fetchChildList() {
        var newList = listOf(
            Child(name = "Bartek", dutyPoints = 10, behaviorPoints = 5, drawableName = "firstavatar" ),
            Child(name = "Tomek", dutyPoints = 15, behaviorPoints = 7, drawableName = "secondavatar" ),
            Child(name = "Antek", dutyPoints = 17, behaviorPoints = 4, drawableName = "thirdavatar" ),
            Child(name = "Ala", dutyPoints = 12, behaviorPoints = 6, drawableName = "fourthavatar" )

        )
        _childList.value = newList

    }

    private val _text = MutableLiveData<String>().apply {
        //value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun onClickAddChild (){
        navigateTo(NavigationCommand.To(HomeFragmentDirections.actionNavigationHomeToNavigationDashboard()))
    }
}