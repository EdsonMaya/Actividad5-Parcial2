package com.example.recyclerview.handlers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
//Datos que van dentro de la card
fun GameData(console: String, price: Int, classification: String) {
    Column () {
        Text(
            text = console,
            fontSize = 10.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = classification,
            fontSize = 10.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "$$price",
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0x00FFFFFF),
        )
    }
}