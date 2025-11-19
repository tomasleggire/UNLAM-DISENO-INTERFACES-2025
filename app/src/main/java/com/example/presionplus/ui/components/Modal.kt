package com.example.presionplus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserSessionModal(onDismiss: () -> Unit) {
    // Main Card Container
    Card(
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2F3651) // Deep blue-gray background
        ),
        modifier = Modifier
            .width(350.dp)
            .wrapContentHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 20.dp, bottom = 40.dp)
        ) {

            // Close Button - aligned to the top end of the Box
            IconButton(
                onClick = onDismiss,
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Cerrar modal",
                    tint = Color.LightGray.copy(alpha = 0.8f)
                )
            }

            // Label: "Usuario actual"
            Text(
                text = "Usuario actual",
                color = Color.LightGray.copy(alpha = 0.8f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Name: "Fernando Gabriel"
            Text(
                text = "Fernando Gabriel",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Top Button: "COMPARTIR CON FAMILIAR"
            // Using a variation of your button with the Maroon/Purple color
            SecondaryButton(
                label = "COMPARTIR CON FAMILIAR",
                onClick = { /* TODO: Handle Share */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom Button: "CERRAR SESION"
            // Using the exact code you provided
            PrimaryButton(
                label = "CERRAR SESION",
                onClick = { /* TODO: Handle Logout */ }
            )
        }


    }
}



@Preview(showBackground = true, backgroundColor = 0xFF1F2336)
@Composable
fun PreviewModal() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        UserSessionModal(onDismiss = {})
    }
}