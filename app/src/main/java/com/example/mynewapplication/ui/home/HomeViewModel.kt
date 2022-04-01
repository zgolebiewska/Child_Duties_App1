package com.example.mynewapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kidsgamesprojects.childduties.ui.BaseViewModel
import com.kidsgamesprojects.childduties.ui.NavigationCommand

class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        //value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun onClickAddChild (){
        navigateTo(NavigationCommand.To(HomeFragmentDirections.actionNavigationHomeToNavigationDashboard()))
    }
}