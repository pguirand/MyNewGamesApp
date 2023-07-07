package com.example.mynewgamesapp.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mynewgamesapp.data.remote.CharCall
import com.example.mynewgamesapp.data.remote.GameCall
import com.example.mynewgamesapp.data.repository.Repository
import com.example.mynewgamesapp.databinding.FragmentSlideshowBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class SlideshowFragment : Fragment() {

    @Inject
    lateinit var repository: Repository
    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        loadData()

        val textCharacter: TextView = binding.textCharacter
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textCharacter.text = it
        }
        return root
    }

    fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {
            val randomChar = Random.nextInt(1,2000)
            var result = repository.getCharacter(randomChar)
            binding.apply {
                textCharacter.text = result.name
                textInfosCharacter.text = result.culture
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}