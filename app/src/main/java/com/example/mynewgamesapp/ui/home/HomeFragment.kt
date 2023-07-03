package com.example.mynewgamesapp.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mynewgamesapp.R
import com.example.mynewgamesapp.data.remote.ApiCall
import com.example.mynewgamesapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var apiCall: ApiCall
    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome

        loadData()



//        binding.btnHomeReload.setOnClickListener {
//            loadData()
//        }

        return root
    }



    fun loadData(){
        CoroutineScope(Dispatchers.Main).launch {
            var result = apiCall.getGamebyId(452)
            var allGames = apiCall.getAllGames()
            val randomElement = Random.nextInt(allGames.size)
            binding.textHome.text = allGames[randomElement].title
            val image = allGames[randomElement].thumbnail


            Glide
                .with(requireContext())
                .load(image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivHome)


            binding.rvHome.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = GameAdapter(allGames, findNavController())

            }


        }





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}