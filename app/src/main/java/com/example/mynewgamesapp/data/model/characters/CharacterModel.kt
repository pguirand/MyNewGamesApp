package com.example.mynewgamesapp.data.model.characters


import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("aliases")
    val aliases: List<String?>? = listOf(),
    @SerializedName("allegiances")
    val allegiances: List<String?>? = listOf(),
    @SerializedName("books")
    val books: List<String?>? = listOf(),
    @SerializedName("born")
    val born: String? = "",
    @SerializedName("culture")
    val culture: String? = "",
    @SerializedName("died")
    val died: String? = "",
    @SerializedName("father")
    val father: String? = "",
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("mother")
    val mother: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("playedBy")
    val playedBy: List<String?>? = listOf(),
    @SerializedName("povBooks")
    val povBooks: List<Any?>? = listOf(),
    @SerializedName("spouse")
    val spouse: String? = "",
    @SerializedName("titles")
    val titles: List<String?>? = listOf(),
    @SerializedName("tvSeries")
    val tvSeries: List<String?>? = listOf(),
    @SerializedName("url")
    val url: String? = ""
)