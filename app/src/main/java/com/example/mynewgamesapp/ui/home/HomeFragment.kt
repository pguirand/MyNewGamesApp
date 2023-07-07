package com.example.mynewgamesapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mynewgamesapp.R
import com.example.mynewgamesapp.data.model.games.SingleGameModel
import com.example.mynewgamesapp.data.remote.GameCall
import com.example.mynewgamesapp.data.repository.Repository
import com.example.mynewgamesapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class HomeFragment : Fragment() {

//    @Inject
//    lateinit var repository: Repository
    lateinit var binding: FragmentHomeBinding


    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val viewmodel by viewModels<HomeViewModel>()
        val root: View = binding.root

        val textView: TextView = binding.textHome

//        loadData()
        if (!viewmodel.isLoaded) {
            viewmodel.getGameData()
        }

        viewmodel.gameLiveData.observe(viewLifecycleOwner) {gameData ->
            loadData(gameData)

        }


//        bin   ding.btnHomeReload.setOnClickListener {
//            loadData()
//        }

        return root
    }



    fun loadData(result: List<SingleGameModel>){
        CoroutineScope(Dispatchers.Main).launch {

            binding.rvHome.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = GameAdapter(result, findNavController())

            }


        }





    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}