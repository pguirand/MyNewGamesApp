package com.example.mynewgamesapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mynewgamesapp.R
import com.example.mynewgamesapp.data.model.games.SingleGameModel
import com.example.mynewgamesapp.databinding.ItemGameBinding
import com.google.gson.Gson

class GameAdapter(val allGames: List<SingleGameModel>, val navController:NavController) : RecyclerView.Adapter<GameAdapter.GameHolder>(){

    class GameHolder(val view: View) : RecyclerView.ViewHolder(view) {
//        val binding = ItemGameBinding.bind(view)
//
//        fun updateUI(singleGame: SingleGameModel) {
//            binding.apply {
//                txTitleGameItem.text = "Title : ${singleGame.title}"
////                txGameItemDescription.text = singleGame.shortDescription
//                txGameItemGenre.text = "Genre : ${singleGame.genre}"
//                Glide
//                    .with(view)
//                    .load(singleGame.thumbnail)
//                    .placeholder(R.drawable.ic_launcher_background)
//                    .into(ivGameItem)
//            }
//        }
        var image:ImageView
        var title:TextView
        init {
            image = view.findViewById(R.id.iv_game_item)
            title = view.findViewById(R.id.tx_title_game_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game,parent,false)
        )
    }

    override fun getItemCount() = allGames.size

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
//        holder.updateUI(allGames[position])
        val gameModel = allGames[position]

        holder.title.text = gameModel.title
                        Glide
                    .with(holder.itemView.context)
                    .load(gameModel.thumbnail)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.image)

        holder.itemView.setOnClickListener {
            navController.navigate(
                R.id.detailFragment,
                bundleOf(
                    "game" to Gson().toJson(gameModel)
                )
            )
        }
    }


}