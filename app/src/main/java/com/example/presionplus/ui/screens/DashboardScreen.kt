package com.example.presionplus.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.presionplus.R
import com.example.presionplus.dmSerifItalic
import com.example.presionplus.ui.components.LightButton
import com.example.presionplus.ui.components.MinMaxInfo
import com.example.presionplus.ui.components.PrimaryButton
import com.example.presionplus.ui.components.UltimaMedicionCard
import com.example.presionplus.ui.components.UserSessionModal
import com.himanshoe.sample.MonthlyStackBarChart
import com.himanshoe.sample.StackBarChart

private const val CHART_TYPE_SEMANA = "SEMANA"
private const val CHART_TYPE_MES = "MES"

@SuppressLint("RememberInComposition")
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    controller: NavHostController,
    onRecordaryButtonClicked: () -> Unit = {},
    onCloseSession: () -> Unit = {},
) {
    // Estado para controlar qué gráfico mostrar ("SEMANA" o "MES")
    var selectedChart by rememberSaveable { mutableStateOf(CHART_TYPE_SEMANA) }
    var showUserSessionModal by rememberSaveable { mutableStateOf(false) }

    Box(Modifier.padding(0.dp)) {
        val alpha: Float by animateFloatAsState(
            targetValue = if (showUserSessionModal) 1f else 0f,
            animationSpec = tween(durationMillis = 300), label = ""
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1F2336))
                .padding(horizontal = 18.dp, vertical = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo02),
                    contentDescription = "Logo de la app",
                    modifier = Modifier.size(48.dp)
                )
                // Icono a la derecha
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Perfil",
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                        .clickable(
                            interactionSource = remember<MutableInteractionSource> { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false), // Now this is acceptable
                            onClick = { showUserSessionModal = true }
                        )
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // ⭐⭐⭐ HEADER CENTRADO (NUEVO)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF0A0D16), shape = RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Texto centrado
                Text(
                    text = "PRESIÓN",
                    color = Color.White,
                    fontFamily = dmSerifItalic,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }


            // ⭐⭐⭐ FIN HEADER

            // ⭐ BLOQUE MÍNIMA / MÁXIMA
            BlockMinMax(Modifier)

            Spacer(modifier = Modifier.height(15.dp))

            // ⭐ Columnas SEMANA / MES
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .background(color = Color(0xFF0A0D16), shape = RoundedCornerShape(10.dp)),
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {
                                selectedChart = CHART_TYPE_SEMANA
                            }
                        )
                ) {
                    Text(
                        text = CHART_TYPE_SEMANA,
                        color = if (selectedChart == CHART_TYPE_SEMANA) Color.White else Color.Gray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(if (selectedChart == CHART_TYPE_SEMANA) Color.White.copy(alpha = 0.20f) else Color.Transparent)
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {
                                selectedChart = CHART_TYPE_MES
                            }
                        )
                ) {
                    Text(
                        text = CHART_TYPE_MES,
                        color = if (selectedChart == CHART_TYPE_MES) Color.White else Color.Gray,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(if (selectedChart == CHART_TYPE_MES) Color.White.copy(alpha = 0.20f) else Color.Transparent)
                    )
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

            Spacer(modifier = Modifier.height(30.dp))

            // 📊 Última medición centrada
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                UltimaMedicionCard(
                    minima = 80,
                    maxima = 120,
                    pulso = 72,
                    fecha = "Hoy 10:35"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            PrimaryButton(label = "AJUSTAR RECORDATORIO", onClick = onRecordaryButtonClicked)

            Spacer(modifier = Modifier.height(20.dp))

            LightButton(label = "GUARDAR INFORMACION", onClick = {})

            Spacer(modifier = Modifier.height(2.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "ultimo informe generado hace 10 min",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp
                )
            }
        }

        if (showUserSessionModal) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.75f * alpha)),
                contentAlignment = Alignment.Center
            ) {
                UserSessionModal(onDismiss = { showUserSessionModal = false }, onCloseSession = onCloseSession)
            }
        }
    }
}

@Composable
private fun BlockMinMax(modifier: Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(modifier = Modifier.weight(1f)) {
            MinMaxInfo(title = "Mínima", minVal = "75", maxVal = "80", modifier = modifier)
        }

        Column(modifier = Modifier.weight(1f)) {
            MinMaxInfo(title = "Máxima", minVal = "100", maxVal = "120", modifier = modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(
        modifier = Modifier,
        controller = rememberNavController()
    )
}
