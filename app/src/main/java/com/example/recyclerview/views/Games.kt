package com.example.recyclerview.views

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recyclerview.viewmodels.GamesViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.recyclerview.handlers.GameCard

fun AgeCheck(age: Int, classification: String): Boolean {
    //Los If para cada situacion depende la clasificacion
    if (classification == "A") {
        return true
    } else if (classification == "B" && age >= 12) {
        return true
    } else if (classification == "B15" && age >= 15) {
        return true
    } else if (classification == "C" && age >= 18) {
        return true
    } else if (classification == "D" && age >= 18) {
        return true
    } else {
        return false
    }
    return false
}
@Composable
fun CardGame(navController: NavHostController, age: Int, budget: Int){
    val GamesViewModel = GamesViewModel()
    val Context = LocalContext.current  //Variable para los desplegables con info
    var available: Int by remember { mutableStateOf(budget) }  //
    var total: Int by remember { mutableStateOf(0) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {

        Box (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "FIFA's",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Acumulado total: $$total",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Todavia tienes: $$available",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Edad: $age años",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(2.dp))

        Button(
            onClick = {navController.navigate("FinalView/$total")
                if(total>0){
                    Toast
                        .makeText(Context, "Tu total es $total", Toast.LENGTH_LONG)
                        .show()
                }
                      },
            colors = ButtonDefaults.buttonColors(Color(0xFF102ABB)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Terminar la compra", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(GamesViewModel.getGameList()) {
                    game ->

                        GameCard(game)

                        Spacer(modifier = Modifier.height(5.dp))

                        Button(
                            onClick = {
                                val isAbleToBuy = AgeCheck(age, game.clas)

                                if (isAbleToBuy) {

                                    if (available >= game.price) {
                                        available = available - game.price
                                        total = total + game.price
                                    }
                                    else {
                                        Toast
                                            .makeText(Context, "Ya no tienes dinero.", Toast.LENGTH_LONG)
                                            .show()
                                    }
                                } else {
                                    Toast
                                        .makeText(Context, "Sos muy joven boludo.", Toast.LENGTH_LONG)
                                        .show()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(Color(0xFF102ABB)),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .width(200.dp)
                        ) {
                            Text(text = "Comprar")
                        }
                        Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

