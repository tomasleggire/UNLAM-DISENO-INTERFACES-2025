package com.example.presionplus.ui.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
fun CalibrationSuccessScreen(
    modifier: Modifier = Modifier,
    controller: NavHostController,
    onContinue: () -> Unit = {}
) {

    val infiniteTransition = rememberInfiniteTransition(label = "radial-animation")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.07f,
        targetValue = 0.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha-animation"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121727))
            .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.smartband),
                    contentDescription = "Pulsera",
                    modifier = Modifier
                        .height(280.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Spacer(
                        Modifier.width(80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.tick_success),
                        contentDescription = "icon success",
                        modifier = Modifier
                            .height(80.dp)
                            .width(80.dp),
                        contentScale = ContentScale.Fit
                    )
                }


            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Calibración finalizada!",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Ahora vamos a poder medir \n" +
                        "la presión con tu pulsera",
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )
        }

        Column(
            modifier = Modifier.weight(0.3f),
            verticalArrangement = Arrangement.Bottom
        ) {
            PrimaryButton(label = "COMENZAR", onClick = onContinue)

            Spacer(modifier = Modifier.height(35.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalibrationSuccessScreenPreview() {
    CalibrationSuccessScreen(
        modifier = Modifier,
        controller = rememberNavController(),
    )
}
