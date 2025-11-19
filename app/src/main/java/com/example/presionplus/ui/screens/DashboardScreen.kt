package com.example.presionplus.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import com.example.presionplus.dmSerifItalic
import com.example.presionplus.ui.components.MinMaxInfo
import com.example.presionplus.ui.components.PrimaryButton
import com.example.presionplus.ui.components.SecondaryButton
import com.example.presionplus.ui.components.UserSessionModal
import com.example.presionplus.ui.components.UltimaMedicionCard
import com.himanshoe.sample.MonthlyStackBarChart
import com.himanshoe.sample.StackBarChart

private const val CHART_TYPE_SEMANA = "SEMANA"
private const val CHART_TYPE_MES = "MES"

@Composable
fun DashboardScreen(modifier: Modifier = Modifier.Companion) {
    // Estado para controlar qué gráfico mostrar ("SEMANA" o "MES")
    var selectedChart by rememberSaveable { mutableStateOf(CHART_TYPE_SEMANA) }
    var showUserSessionModal by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(Color(0xFF1F2336))
            .padding(horizontal = 18.dp, vertical = 20.dp)
    ) {

        // ⭐⭐⭐ HEADER CENTRADO (NUEVO)
        Box(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            // Texto centrado
            Text(
                text = "Presión+",
                color = Color.Companion.White,
                fontFamily = dmSerifItalic,
                fontSize = 20.sp,
                modifier = Modifier.Companion.align(Alignment.Companion.Center)
            )

            // Icono a la derecha
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Perfil",
                tint = Color.White,
                modifier = Modifier.Companion
                    .size(50.dp)
                    .align(Alignment.Companion.CenterEnd)
                    .clickable { showUserSessionModal = true }
            )
        }
        AnimatedVisibility(visible = showUserSessionModal, enter = slideInHorizontally(), exit = slideOutHorizontally()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                UserSessionModal(onDismiss = { showUserSessionModal = false })
            }

        }
        // ⭐⭐⭐ FIN HEADER

        // ⭐ BLOQUE MÍNIMA / MÁXIMA
        BlockMinMax(Modifier)

        // ⭐ Columnas SEMANA / MES
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.5f),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextButton(onClick = { selectedChart = CHART_TYPE_SEMANA }) {
                    Text(
                        text = CHART_TYPE_SEMANA,
                        color = if (selectedChart == CHART_TYPE_SEMANA) Color.White else Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }
                TextButton(onClick = { selectedChart = CHART_TYPE_MES }) {
                    Text(
                        text = CHART_TYPE_MES,
                        color = if (selectedChart == CHART_TYPE_MES) Color.White else Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // 📊 Columna que cambia el contenido del gráfico
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (selectedChart) {
                CHART_TYPE_SEMANA -> StackBarChart()
                CHART_TYPE_MES -> MonthlyStackBarChart()
            }
        }

        // 📊 Última medición centrada
        Box(
            modifier = Modifier.Companion.fillMaxWidth(),
            contentAlignment = Alignment.Companion.Center
        ) {
            UltimaMedicionCard(
                minima = 80,
                maxima = 120,
                pulso = 72,
                fecha = "09/11/2025 19:30"
            )
        }

        Spacer(modifier = Modifier.Companion.height(20.dp))

        PrimaryButton(label = "AJUSTAR RECORDATORIO", onClick = {})

        Spacer(modifier = Modifier.Companion.height(20.dp))

        SecondaryButton(label = "GUARDAR INFORMACION", onClick = {})
    }
}

@Composable
private fun BlockMinMax(modifier: Modifier) {
    Row(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(modifier = Modifier.Companion.weight(1f)) {
            MinMaxInfo(title = "Mínima", minVal = "100", maxVal = "100", modifier = modifier)
        }

        Column(modifier = Modifier.Companion.weight(1f)) {
            MinMaxInfo(title = "Máxima", minVal = "75", maxVal = "75", modifier = modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}
