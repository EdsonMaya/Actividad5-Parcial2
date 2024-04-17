package com.example.recyclerview.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inicio (navController: NavHostController){
    var age: Int by remember{ mutableStateOf(0)}
    var budget: Int by remember{ mutableStateOf(0)}

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = age.toString(),
            onValueChange = { age = it.toInt() },
            label = { Text("Ingresa tu edad friki") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = budget.toString(),
            onValueChange = { budget = it.toInt() },
            label = { Text("Ingresa tu presupuesto") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        )
        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick = {
                navController.navigate("Games/$age/$budget")
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF102ABB)),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Continuar",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

