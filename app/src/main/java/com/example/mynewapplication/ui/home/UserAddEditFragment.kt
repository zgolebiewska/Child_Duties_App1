package com.example.mynewapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.mynewapplication.R
import com.example.mynewapplication.databinding.FragmentUserAddEditBinding
import com.example.mynewapplication.ui.BaseFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.ArrayList


@AndroidEntryPoint

class UserAddEditFragment : BaseFragment<ChildAddOrEditViewModel>(ChildAddOrEditViewModel::class.java) {


    //val args: UserAddEditFragmentArgs by navArgs()
    private var _binding: FragmentUserAddEditBinding? = null

    private val binding get() = _binding!!
    private val circleLinearLayoutMap = mutableMapOf<String, LinearLayout>()

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val childAddOrEditViewModel = ViewModelProvider(this).get(ChildAddOrEditViewModel::class.java)
//        _binding = FragmentUserAddEditBinding.inflate(inflater, container, false)
//        createAvatarsCards()
//
//
//        return binding.root
//    }

//    private fun createAvatarsCards() {
//        var drawableList = listOf(
//            R.drawable.firstavatar,
//            R.drawable.secondavatar,
//            R.drawable.thirdavatar,
//            R.drawable.fourthavatar
//        )
//
//        for (index in drawableList.indices){
//
////            val cardView: CardView = LayoutInflater.from(context)
////                .inflate(R.layout.item_avatar, binding.gridLayoutAvatarList, false) as CardView
//
//            val rowSpec = GridLayout.spec(index / 4, 1, 0.25f)
//            val colSpec = GridLayout.spec(index % 4, 1, 0.25f)
//            val myGLP = GridLayout.LayoutParams(rowSpec, colSpec)
////            binding.gridLaouytAvatarList.addView(cardView, myGLP)
//
//        }
//
//    }


//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

    /* companion object {
         fun newInstance(param1: String, param2: String) =
             UserAddEditFragment().apply {
                 arguments = Bundle().apply {
                     putString(ARG_PARAM1, param1)
                     putString(ARG_PARAM2, param2)
                 }
             }
     }*/

 /*   fun findViewWithTagRecursively(root: ViewGroup, tag: Any): List<View> {
        val allViews: MutableList<View> = ArrayList()
        val childCount = root.childCount
        for (i in 0 until childCount) {
            val childView = root.getChildAt(i)
            if (childView is ViewGroup) {
                allViews.addAll(findViewWithTagRecursively(childView, tag)!!)
            }
//            else {
            val tagView = childView.tag
            if (tagView != null && tagView == tag) allViews.add(childView)
//            }
        }
        return allViews
    }

*/





}