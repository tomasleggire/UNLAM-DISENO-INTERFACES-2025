package com.himanshoe.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himanshoe.charty.bar.LineStackedBarChart
import com.himanshoe.charty.bar.config.StackBarConfig
import com.himanshoe.charty.bar.model.StackBarData
import com.himanshoe.charty.common.ChartColor
import com.himanshoe.charty.common.LabelConfig
import com.himanshoe.charty.common.asSolidChartColor

@Composable
fun MonthlyStackBarChart() {
    Column {
        val normalColors = listOf(
            ChartColor.Gradient(
                listOf(
                    Color(0xFFFFFF),
                    Color(0xFFFFFF)
                )
            ),
            ChartColor.Gradient(
                listOf(
                    Color(0xFF99FFA3),
                    Color(0xFF68EE76),
                )
            ),
        )

        val mediumColors = listOf(
            ChartColor.Gradient(
                listOf(
                    Color(0xFFFFFF),
                    Color(0xFFFFFF)
                )
            ),
            ChartColor.Gradient(
                listOf(
                    Color(0xFFFFF176),
                    Color(0xFFFFEB3B),
                )
            ),
        )

        val highColors = listOf(
            ChartColor.Gradient(
                listOf(
                    Color(0xFFFFFF),
                    Color(0xFFFFFF)
                )
            ),
            ChartColor.Gradient(
                listOf(
                    Color(0xFFFF9AA3),
                    Color(0xFFFF6B76),
                )
            ),
        )

        // Static values: 30% between 60-80, 30% between 70-85, rest 75-100
        val staticValues = listOf(
            // First 9 days (30%): range 60-80
            65f to 35f, // 1
            70f to 28f, // 2
            68f to 32f, // 3
            62f to 39f, // 4
            80f to 20f, // 5
            73f to 33f, // 6
            66f to 37f, // 7
            71f to 29f, // 8
            64f to 38f, // 9

            // Next 9 days (30%): range 70-85
            62f to 53f, // 10
            70f to 45f, // 11
            67f to 51f, // 12
            75f to 40f, // 13
            64f to 54f, // 14
            72f to 48f, // 15
            61f to 50f, // 16
            69f to 46f, // 17
            73f to 42f, // 18

            // Remaining 13 days (40%): range 75-100
            80f to 40f, // 19
            95f to 48f, // 20
            88f to 42f, // 21
            100f to 45f, // 22
            76f to 49f, // 23
            93f to 55f, // 24
            82f to 48f, // 25
            97f to 51f, // 26
            86f to 44f, // 27
            91f to 59f, // 28
            79f to 40f, // 29
            96f to 53f, // 30
            87f to 47f  // 31
        )

        val data = staticValues.mapIndexed { index, values ->
            val (value1, value2) = values
            val colors =
                when {
                    value1 + value2 < 110f -> normalColors // Range 60-80
                    value1 + value2 < 135f -> mediumColors // Range 70-85
                    value1 + value2 < 175f -> highColors // Range 75-100
                    else -> highColors
                }

            StackBarData(
                label = (index + 1).toString(),
                values = listOf(value1, value2),
                // Using simpleColors for clarity as mediumColors is unused in this logic.
                colors = colors
            )
        }

        Column {
            LineStackedBarChart(
                data = { data },
                modifier = Modifier.Companion.fillMaxWidth().height(200.dp).padding(24.dp),
                stackBarConfig = StackBarConfig.Companion.default().copy(
                    showCurvedBar = true,
                ),
                labelConfig = LabelConfig.Companion.default().copy(
                    showXLabel = true,
                    xAxisCharCount = 2,
                    showYLabel = true,
                    textColor = Color.Companion.White.asSolidChartColor(),
                    labelTextStyle = TextStyle(fontSize = 8.sp)
                ),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(0.25f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color(0xFF68EE76), CircleShape)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Normal", color = Color.White)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text("70%", color = Color.White)
                    }
                }

//                Spacer(modifier = Modifier.weight(0.1f))

                Column(
                    modifier = Modifier.weight(0.25f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color(0xFFFFEB3B), CircleShape)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Medio", color = Color.White)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text("20%", color = Color.White)
                    }
                }

//                Spacer(modifier = Modifier.weight(0.1f))

                Column(
                    modifier = Modifier.weight(0.30f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color(0xFFFF6B76), CircleShape)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Hipertension", color = Color.White)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text("30%", color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun AddMonthlyStackBarChartPreview() {
    MonthlyStackBarChart()
}