package com.example.presionplus.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.presionplus.R
import com.example.presionplus.ui.components.PrimaryButton


@Composable
fun CalibrationScreen(
    modifier: Modifier = Modifier,
    controller: NavHostController,
    onContinue: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121727))
            .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(70.dp)) // 🔥 Baja un poco todo

        Text(
            text = "Calibración finalizada",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Ahora podés realizar una medición de presión en tu pulsera.\n" +
                    "Usá el reloj en la misma muñeca en la que lo llevaste durante la calibración.",
            color = Color.White.copy(alpha = 0.85f),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "¿Cómo medir?",
            color = Color.White,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(55.dp))

        // 🔥 IMAGEN MÁS GRANDE Y MÁS ABAJO
        Image(
            painter = painterResource(id = R.drawable.smartband),
            contentDescription = "Pulsera",
            modifier = Modifier
                .height(330.dp)          // ← Aumentado
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(70.dp))   // 🔥 Baja un poco más el botón

        PrimaryButton(label = "CONTINUAR", onClick = onContinue)

        Spacer(modifier = Modifier.height(35.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalibrationScreenPreview() {
    CalibrationScreen(
        modifier = Modifier,
        controller = rememberNavController(),
    )
}
