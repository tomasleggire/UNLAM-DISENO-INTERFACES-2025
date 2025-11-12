package com.example.presionplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presionplus.ui.theme.PresionPlusTheme
import com.example.presionplus.ui.components.UltimaMedicionCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresionPlusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F2336))
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        Column( // 👈 ahora sí, todo en columna para que baje
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // --- HEADER ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Presión+",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Perfil",
                    tint = Color.Gray,
                    modifier = Modifier.size(50.dp)
                )
            }

            // --- ESPACIO PARA BAJAR EL COMPONENTE ---
            Spacer(modifier = Modifier.height(300.dp)) // ⬅️ probá subir o bajar este valor

            // --- TU TARJETA ---
            UltimaMedicionCard(
                minima = 80,
                maxima = 120,
                pulso = 72,
                fecha = "09/11/2025 19:30"
            )
        }
     /*
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🔹 Header con título e ícono de perfil
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Presion+",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Perfil",
                tint = Color.Gray,
                modifier = Modifier.size(50.dp)
            )
        }


        Spacer(modifier = Modifier.height(450.dp))

        // 🔹 Tarjeta de última medición
        UltimaMedicionCard(
            minima = 80,
            maxima = 120,
            pulso = 72,
            fecha = "09/11/2025 19:30"
        )
        */
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PresionPlusTheme {
        Greeting()
    }
}
