package com.example.presionplus.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presionplus.R

import androidx.compose.ui.text.googlefonts.GoogleFont


private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val dmSerifItalic = FontFamily(
    Font(
        googleFont = GoogleFont("DM Serif Text Italic"),
        fontProvider = provider
    )
)



@Composable
fun WelcomeScreen(
    onIniciarSesionClick: () -> Unit = {},
    onCrearCuentaClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F2336))
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Spacer(modifier = Modifier.height(210.dp))

        // ⭐ Logo
        Image(
            painter = painterResource(id = R.drawable.logo02),
            contentDescription = "Logo de la app",
            modifier = Modifier.size(160.dp)
        )


        // ⭐ Título Presión+
        Text(
            text = "Presión+",
            fontSize = 40.sp,
            color = Color.White,
            fontFamily = dmSerifItalic
        )

        Spacer(modifier = Modifier.height(250.dp))   // 👈 LO BAJA BIEN COMO TU MAQUETA

        // ⭐ Crear cuenta
        Text(
            text = "Crear Cuenta",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .clickable { onCrearCuentaClick() }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // ⭐ Botón Iniciar sesión
        Button(
            onClick = onIniciarSesionClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF007F)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "INICIAR SESIÓN",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(
        onCrearCuentaClick = {},
        onIniciarSesionClick = {}
    )
}
