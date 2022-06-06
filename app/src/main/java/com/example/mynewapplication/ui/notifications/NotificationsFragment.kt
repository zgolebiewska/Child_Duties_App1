package com.example.mynewapplication.ui.notifications

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
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.mynewapplication.R
import com.example.mynewapplication.databinding.FragmentNotificationsBinding
import com.example.mynewapplication.ui.BaseFragment
import com.example.mynewapplication.ui.home.UserAddEditFragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.ArrayList


class NotificationsFragment : Fragment() {

    //val args: NotificationsFragmentArgs by navArgs()
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val circleLinearLayoutMap = mutableMapOf<String, LinearLayout>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val addChildViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        createAvatarsCards()

        return binding.root
    }

    private fun createAvatarsCards() {
        var drawableList = listOf(
            Pair(R.drawable.firstavatar, "firstavatar"),
            Pair(R.drawable.secondavatar, "secondavatar"),
            Pair(R.drawable.thirdavatar, "thirdavatar"),
            Pair(R.drawable.fourthavatar, "fourthavatar"),
        )

        for (index in drawableList.indices){
                val cardView: CardView = LayoutInflater.from(context)
                    .inflate(R.layout.item_avatar, binding.gridLayoutAvatarList, false) as CardView

            //cardView.findViewWithTag<ShapeableImageView>("ShapeableImageView")?.setImageResource(drawableList[index].first)
            val rowSpec: GridLayout.Spec = GridLayout.spec(index / 4, 1, 0.25f)
            val colSpec: GridLayout.Spec = GridLayout.spec(index % 4, 1, 0.25f)
            val myGLP = GridLayout.LayoutParams(rowSpec, colSpec)

            //circleLinearLayoutMap[drawableList[index].second = findViewWithTagRecursively(cardView, "layoutWithCircle")[0] as LinearLayout
            binding.gridLayoutAvatarList.addView(cardView, myGLP)

        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun findViewWithTagRecursively(root: ViewGroup, tag: Any): List<View> {
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonAddOrEditChild).setOnClickListener{
            firestoreTest()
        }
    }

    private fun firestoreTest() {
        val db = Firebase.firestore

        // Create a new user with a first and last name
        val child = hashMapOf(
            "name" to "Ada",
            "behaviourPoints" to 10,
            "dutyPoints" to 0,
            "drawableName" to "firstavatar"
        )

// Add a new document with a generated ID
        db.collection("users")
            .add(child)
            .addOnSuccessListener { documentReference ->
                Log.d("Firebase CLoud", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Firebase Cloud", "Error adding document", e)
            }
    }


}