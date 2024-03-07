package com.example.recyclerview.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recyclerview.R

@Preview(showBackground = true)
@Composable
fun CardGame(){
    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth() ) {
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(120.dp),
                painter = painterResource(id = R.drawable.fifa7 ),
                contentDescription = "Game Image" ,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "FIFA  07",
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(0xFF673AB7)
            )
                GameDataView(Modifier.fillMaxWidth())

                Button(onClick = { }){
                    Text(text = "Comprar")
                }
            }
        }
        //Imagen

        //Nombre del juego
        //Consola y precio

        //Button

    }
}

