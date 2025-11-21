package com.example.presionplus.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MinMaxInfo(title: String, minVal: String, maxVal: String, modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            color = Color.Companion.White,
            textAlign = TextAlign.Companion.Center,
            modifier = Modifier.Companion.fillMaxWidth(),
            fontWeight = FontWeight.Companion.Bold
        )
        Row(
            modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Min.", color = Color.Companion.White, fontSize = 12.sp)
            Text(text = "Max.", color = Color.Companion.White, fontSize = 12.sp)
        }
        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = minVal,
                color = Color.Companion.White,
                fontWeight = FontWeight.Companion.Bold,
            )
            Text(text = maxVal, color = Color.Companion.White, fontWeight = FontWeight.Companion.Bold)
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF1F2336)
@Composable
fun MinMaxInfoPreview() {
    MinMaxInfo(title = "Mínima", minVal = "100", maxVal = "100", modifier = Modifier)
}