package com.example.mynewgamesapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mynewgamesapp.ListCategoryFragment
import com.example.mynewgamesapp.data.remote.ApiCall
import com.example.mynewgamesapp.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class GalleryFragment : Fragment() {

    @Inject
    lateinit var apiCall: ApiCall
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        try {
            loadData()

        } catch (e:Exception) {
            print(e.printStackTrace())
        }
        return root
    }

    fun loadData() {
        var uniqueCategories = arrayListOf<String>()
        val allCategories = arrayListOf<String>()
        var currentCategory = ""

        CoroutineScope(Dispatchers.Main).launch {
            val allGames = apiCall.getAllGames()
            val length = allGames.size

            allGames.forEach {
                it.genre?.let { it1 -> allCategories.add(it1) }
            }
            println(allCategories)
            uniqueCategories = allCategories.distinct() as ArrayList<String>
            binding.textGallery.text = uniqueCategories.size.toString()


            binding.rvCategory.apply {
                layoutManager =  StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
//                layoutManager = LinearLayoutManager(context)
                adapter = CategoryAdapter(uniqueCategories= uniqueCategories, navController = findNavController())
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun onSelected(result: String) {

    }

    private fun onListItemClick(position: Int) {
        Toast.makeText(context, "Postition " + position, Toast.LENGTH_SHORT).show()

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace((requireView().parent as ViewGroup).id, ListCategoryFragment())
        transaction.disallowAddToBackStack()
        transaction.commit()
    }
}