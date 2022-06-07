package com.example.mynewapplication.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mynewapplication.data.Child
import com.example.mynewapplication.ui.BaseViewModel
import com.example.mynewapplication.ui.NavigationCommand
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class HomeViewModel : BaseViewModel() {

    private val _childList = MutableLiveData<List<Child>>()
    val childList : LiveData<List<Child>> = _childList

    init{
        fetchChildList()
    }

    //internal var child: Child? = null

    private fun fetchChildList() {



        val db = Firebase.firestore
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Firebase CLoud get", "${document.id} => ${document.data}")

                    var newList = listOf(Child(document.id.toString(),document.data.toString()))
                    _childList.value = newList

                }
            }
            .addOnFailureListener { exception ->
                Log.w("Firebase CLoud get", "Error getting documents.", exception)
            }






    }



    private val _text = MutableLiveData<String>().apply {
        //value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun onClickAddChild (){
     navigateTo(NavigationCommand.To(HomeFragmentDirections.actionNavigationHomeToNavigationNotifications()))

    }


}