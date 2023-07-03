package com.example.mynewgamesapp.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mynewgamesapp.data.model.games.SingleGameModel
import com.example.mynewgamesapp.databinding.FragmentDetailBinding
import com.google.gson.Gson

class DetailFragment:Fragment() {

    lateinit var binding:FragmentDetailBinding

    lateinit var gameModel: SingleGameModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gameModel = Gson().fromJson(arguments?.getString("game"), SingleGameModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Toast.makeText(requireContext(), gameModel.title, Toast.LENGTH_SHORT).show()

        binding.title.text = gameModel.title
        binding.description.text = gameModel.shortDescription

        Glide.with(requireContext())
            .load(Uri.parse(gameModel.thumbnail))
            .into(binding.image)
    }
}