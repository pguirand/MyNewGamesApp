package com.example.mynewgamesapp.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mynewgamesapp.R
import com.example.mynewgamesapp.databinding.FragmentListCategoryBinding

class ListCategoryFragment : Fragment() {

    lateinit var binding : FragmentListCategoryBinding

    lateinit var strItem:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        strItem = arguments?.getString("item")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), strItem, Toast.LENGTH_SHORT).show()
    }
}