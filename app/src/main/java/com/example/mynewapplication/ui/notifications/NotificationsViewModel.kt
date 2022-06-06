package com.example.mynewapplication.ui.notifications

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewapplication.data.Child
import com.example.mynewapplication.ui.BaseViewModel
import com.example.mynewapplication.ui.NavigationCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
//
//@HiltViewModel
class NotificationsViewModel : BaseViewModel() {


    private val _child = MutableLiveData<Child>()
    val child = _child



    override fun prepare(args: Bundle?){
        super.prepare(args)
        if (args == null) {
            _child.value = Child(name = "", behaviorPoints = 0, dutyPoints = 0, drawableName = "firstavatar")
        }
        /*val childId = args.getLong("childId");
        if (childId == null || childId == 0L) {
            addMode = true
            _child.value = Child(name = "", behaviourPoints = 0, drawableName = "avatar_smok", birthday = Date())
        } else {
            fetchChild(childId)
            addMode = false
            //TODO: Load Data from room?
        }*/
    }

    /*private fun fetchChild(childId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            childRepository.getChild(childId).collect {
                _child.postValue(it)
            }
        }
    }

    fun addChildOrEdit() {
        if (addMode) {
            val tempName = _child.value!!.name
            val tempAvatarName = _child.value!!.drawableName

            if (!tempName.isNullOrEmpty() && !tempAvatarName.isNullOrEmpty()) {
                viewModelScope.launch(Dispatchers.IO) {
                    childRepository.addChild(_child.value!!)
                    navigateTo(NavigationCommand.BackTo(UserAddEditFragmentDirections.actionUserAddEditFragmentToNavigationHome().actionId))
                }
            } else {
                //TODO: show error null?
            }
        } else {
            viewModelScope.launch(Dispatchers.IO) { childRepository.updateChild(_child.value!!) }
            navigateTo(NavigationCommand.BackTo(UserAddEditFragmentDirections.actionUserAddEditFragmentToNavigationHome().actionId))
        }

    }

    fun cancelAddOrEdit() {
        navigateTo(NavigationCommand.BackTo(UserAddEditFragmentDirections.actionUserAddEditFragmentToNavigationHome().actionId))
    }

    fun askToDeleteChild() {
        if (child.value != null)
            deleteChildDialogRequest.postValue(child.value)
    }

    fun deleteChild(child: Child) {
        viewModelScope.launch(Dispatchers.IO) {
            childRepository.deactivateChild(child)
            cancelAddOrEdit()
        }}*/
}