package com.example.recyclerview.viewmodels

import androidx.lifecycle.ViewModel
import com.example.recyclerview.R
import com.example.recyclerview.models.Game

class GamesViewModel: ViewModel() {

    init{
        //constructor
    }

    fun getGameList() : ArrayList<Game>{
        val game: Game = Game("FIFA 17",  999, "PS4", R.drawable.fifa7)
        var gameList: ArrayList<Game>  = ArrayList<Game>() //lista vacia de juegos
        gameList.add(game)

        gameList.add(Game("FIFA 7", 1100, "PS2", R.drawable.fifa7))
        gameList.add(Game("FIFA 8", 1200, "PS2", R.drawable.fifa8))
        gameList.add(Game("FIFA 9", 1250, "PS2", R.drawable.fifa9))
        gameList.add(Game("FIFA 10", 1260, "PS3", R.drawable.fifa10))
        gameList.add(Game("FIFA 11", 1270, "PS3", R.drawable.fifa11))
        gameList.add(Game("FIFA 12", 1280, "PS3", R.drawable.fifa12))
        gameList.add(Game("FIFA 13", 1300, "PS3", R.drawable.fifa13))
        gameList.add(Game("FIFA 14", 1350, "PS3", R.drawable.fifa14))
        gameList.add(Game("FIFA 15", 1360, "PS3", R.drawable.fifa15))
        gameList.add(Game("FIFA 16", 1400, "PS3", R.drawable.fifa16))

        return gameList //regresamos la lista de juegos

    }
}