package com.example.presionplus.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondaryButton(onClick: () -> Unit, label: String) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF863755)
        ),
        modifier = Modifier.Companion
            .fillMaxWidth()
            .height(55.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = label,
            color = Color.Companion.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Companion.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryButtonPreview() {
    SecondaryButton(
        onClick = { },
        label = "Secondary Button"
    )
}