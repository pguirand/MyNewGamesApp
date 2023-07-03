package com.example.mynewgamesapp.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewgamesapp.R
import com.example.mynewgamesapp.databinding.ItemCategoryBinding
import com.google.gson.Gson

class CategoryAdapter(
    val uniqueCategories: ArrayList<String>,
//    private val onItemClicked: (position: Int) -> Unit,
    val navController: NavController
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View/*, val onItemClicked: (position: Int) -> Unit*/) :
        RecyclerView.ViewHolder(view)/*, View.OnClickListener*/ {

        val btn:Button

        init {
            btn = view.findViewById(R.id.btn_item_catogory)
        }

//        override fun onClick(p0: View?) {
//            val position = adapterPosition
//            onItemClicked(position)
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(
            view/*, onItemClicked*/
        )
    }

    override fun getItemCount() = uniqueCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = uniqueCategories[position]
//        holder.updateUI(uniqueCategories[position])
        holder.btn.text = item
        holder.btn.setOnClickListener {
//            this
            navController.navigate(
                R.id.listCategoryFragment,
                bundleOf(
                    "item" to item
                )
            )
        }
    }


}