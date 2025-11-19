package com.example.presionplus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun RecordatoryScreen(
    modifier: Modifier = Modifier,
    controller: NavHostController,
) {
    var showModal by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121727))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            Text(
                text = "Recordatorio",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Establece un recordatorio para registrar los datos de salud",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.W300,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF0E5EBD))
                    .padding(horizontal = 18.dp, vertical = 14.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF0A0D1A))
                    .padding(horizontal = 18.dp, vertical = 20.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Presión arterial",
                        color = Color(0xFFEE5A7C),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W400
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFEE5A7C))
                            .clickable { showModal = true }
                            .padding(horizontal = 10.dp, vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Agregar",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )

                        Spacer(modifier = Modifier.width(2.dp))

                        Text(
                            text = "AGREGAR",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                ReminderItem(
                    time = "06:00",
                    subtitle = "L   M   M   J   V"
                )

                Spacer(modifier = Modifier.height(14.dp))

                ReminderItem(
                    time = "20:00",
                    subtitle = "Todos los días"
                )
            }
        }

        if (showModal) {
            AddReminderModal(
                onCancel = { showModal = false },
                onSave = { showModal = false }
            )
        }
    }
}

@Composable
fun ReminderItem(time: String, subtitle: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(Color(0xFF2F3445))
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            Text(
                text = time,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = subtitle,
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )
        }

        Box(
            modifier = Modifier
                .size(width = 52.dp, height = 28.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF4A3A49)),
            contentAlignment = Alignment.CenterEnd
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE8516E))
            )
        }
    }
}

@Composable
fun AddReminderModal(
    onCancel: () -> Unit,
    onSave: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth(0.90f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(28.dp),
        ) {

            Column(
                modifier = Modifier
                    .background(Color(0xFF2F3445))
                    .padding(vertical = 30.dp, horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TimeNumber("06")
                    Spacer(Modifier.width(12.dp))
                    Text(":", color = Color.White, fontSize = 38.sp)
                    Spacer(Modifier.width(12.dp))
                    TimeNumber("00")
                }

                Spacer(Modifier.height(26.dp))

                val dias = listOf("L", "M", "M", "J", "V", "S", "D")
                var selected by remember { mutableStateOf(setOf("L", "M", "M2", "J", "V")) }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    dias.forEachIndexed { index, dia ->

                        val key = if (dia == "M" && index == 2) "M2" else dia
                        val isSelected = key in selected

                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(44.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    if (isSelected) Color(0xFFFF5D8A)
                                    else Color(0xFF0D1220)
                                )
                                .clickable {
                                    selected =
                                        if (isSelected) selected - key else selected + key
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = dia,
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(Modifier.height(28.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFF0D1220))
                            .clickable { onCancel() }
                            .padding(horizontal = 34.dp, vertical = 14.dp)
                    ) {
                        Text(
                            "CANCELAR",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFFFF5D8A))
                            .clickable { onSave() }
                            .padding(horizontal = 34.dp, vertical = 14.dp)
                    ) {
                        Text(
                            "GUARDAR",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TimeNumber(value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            fontSize = 48.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .width(48.dp)
                .height(2.dp)
                .background(Color(0xFFFF5D8A))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecordatoryScreenPreview() {
    RecordatoryScreen(
        modifier = Modifier,
        controller = rememberNavController()
    )
}