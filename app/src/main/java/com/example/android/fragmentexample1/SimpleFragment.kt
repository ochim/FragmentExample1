package com.example.android.fragmentexample1


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 */
class SimpleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_simple, container, false)

        val radioGroup = rootView.findViewById<RadioGroup>(R.id.radio_group)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->

            val radioButton = radioGroup.findViewById<View>(checkedId)
            val index = radioGroup.indexOfChild(radioButton)
            val textView = rootView.findViewById<TextView>(R.id.fragment_header)

            when (index) {
                YES -> textView.setText(R.string.yes_message)
                NO -> textView.setText(R.string.no_message)
                else -> {
                }
            }
        }

        val ratingBar = rootView.findViewById<RatingBar>(R.id.rating_bar)

        ratingBar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(context, "My Rating: ${ratingBar.rating}", Toast.LENGTH_SHORT).show()
        }

        return rootView
    }

    companion object {

        private val YES = 0
        private val NO = 1
    }

}