package com.example.recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recyclerview.models.Game
import com.example.recyclerview.ui.theme.RecyclerViewTheme
import com.example.recyclerview.viewmodels.GamesViewModel
import com.example.recyclerview.views.CardGame

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewTheme {
                val gamesViewModel = GamesViewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                //llamar y mostrar la lista
                    LazyColumn{
                        items(gamesViewModel.getGameList()){game->
                            //dentro de los parentesis va la lista o arreglo de datos
                            //dentro de las llaves seria la visita a repetir
                            CardGame(game)
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainView(){
    val gamesViewModel = GamesViewModel()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecyclerViewTheme {
    }
}