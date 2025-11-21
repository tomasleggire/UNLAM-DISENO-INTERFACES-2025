package com.himanshoe.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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
fun StackBarChart() {
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

        val data = listOf(
            StackBarData(
                label = "L", values = listOf(60f, 35f), colors = mediumColors
            ), StackBarData(
                label = "M", values = listOf(60f, 30f), colors = normalColors
            ), StackBarData(
                label = "M", values = listOf(60f, 30f), colors = normalColors
            ), StackBarData(
                label = "J", values = listOf(60f, 30f), colors = normalColors
            ), StackBarData(
                label = "V", values = listOf(60f, 40f), colors = highColors
            ), StackBarData(
                label = "S", values = listOf(60f, 25f), colors = normalColors
            ), StackBarData(
                label = "D", values = listOf(60f, 30f), colors = normalColors
            )
        )

        val borderRadius = 20f
        LineStackedBarChart(
            data = { data },
            modifier = Modifier.Companion
                .fillMaxWidth()
                .height(250.dp)
                .padding(24.dp),
            stackBarConfig = StackBarConfig.default().copy(
                showCurvedBar = true
            ),
            labelConfig = LabelConfig.Companion.default().copy(
                showXLabel = true,
                showYLabel = true,
                textColor = Color.Companion.White.asSolidChartColor(),
                labelTextStyle = TextStyle(fontSize = 15.sp)
            ),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun StackBarChartPreview() {
    StackBarChart()
}