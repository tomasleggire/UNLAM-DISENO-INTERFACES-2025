package com.example.presionplus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UltimaMedicionCard(
    minima: Int,
    maxima: Int,
    pulso: Int,
    fecha: String
) {
    // 🔹 Calcula automáticamente el estado según los valores
    val estado = when {
        maxima > 130 || minima > 85 -> "Alta"
        maxima < 90 || minima < 60 -> "Baja"
        else -> "Normal"
    }

    // 🔹 Define el color según el estado
    val colorEstado = when (estado) {
        "Alta" -> Color(0xFFFF6B6B)
        "Baja" -> Color(0xFFFFD93D)
        else -> Color(0xFF12BB6F)
    }

    // 🔹 Estructura visual
    Card(
        modifier = Modifier
            .width(350.dp)
            .height(132.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF252C44)
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // --- Encabezado ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Última medición",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = fecha,
                    color = Color(0xFFC2C2C4),
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // --- Valores principales ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "$minima",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .width(45.dp)
                            .height(1.dp)
                            .background(Color.White)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$maxima",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(17.dp)
                            .clip(CircleShape)
                            .background(colorEstado)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = estado,
                        color = Color.White,
                        fontSize = 25.sp,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Min.                 Max.",
                    color = Color(0xFFC2C2C4),
                    style = MaterialTheme.typography.bodySmall
                )


                // --- Pulso ---
                Text(
                    text = "Pulso: $pulso BPM",
                    color = Color(0xFFC2C2C4),
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1F2336)
@Composable
fun UltimaMedicionCardPreview() {
    UltimaMedicionCard(
        minima = 85,
        maxima = 135,
        pulso = 75,
        fecha = "09/11/2025 19:45"
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF1F2336)
@Composable
fun UltimaMedicionCardPreviewNormal() {
    UltimaMedicionCard(
        minima = 80,
        maxima = 120,
        pulso = 60,
        fecha = "10/11/2025 08:00"
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF1F2336)
@Composable
fun UltimaMedicionCardPreviewBaja() {
    UltimaMedicionCard(
        minima = 55,
        maxima = 85,
        pulso = 55,
        fecha = "10/11/2025 09:30"
    )
}