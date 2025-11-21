package com.example.presionplus.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presionplus.ui.screens.CalibrationScreen
import com.example.presionplus.ui.screens.CalibrationSuccessScreen
import com.example.presionplus.ui.screens.DashboardScreen
import com.example.presionplus.ui.screens.RecordatoryScreen
import com.example.presionplus.ui.screens.WelcomeScreen

@Composable
fun NavigationComponent() {
    val controller = rememberNavController()
    Scaffold { paddingValue ->
        NavHost(navController = controller, startDestination = NavHostRouterPaths.WELCOME.route) {
            composable(NavHostRouterPaths.WELCOME.route) {
                // Home es el componente en sí que es el destino de navegación.
                WelcomeScreen(modifier = Modifier.padding(paddingValue), controller = controller, onIniciarSesionClick = {
                    controller.navigate(NavHostRouterPaths.DASHBOARD.route)
                }, onCrearCuentaClick = {
                    controller.navigate(NavHostRouterPaths.CALIBRATION.route)
                })
            }
            composable(NavHostRouterPaths.CALIBRATION.route) {
                CalibrationScreen(modifier = Modifier.padding(paddingValue), controller = controller, onContinue = {
                    controller.navigate(NavHostRouterPaths.CALIBRATION_SUCCESS.route)
                })
            }
            composable(NavHostRouterPaths.CALIBRATION_SUCCESS.route) {
                CalibrationSuccessScreen(modifier = Modifier.padding(paddingValue), controller = controller, onContinue = {
                    controller.navigate(NavHostRouterPaths.DASHBOARD.route)
                })
            }
            composable(NavHostRouterPaths.DASHBOARD.route) {
                DashboardScreen(modifier = Modifier.padding(paddingValue), controller = controller, onRecordaryButtonClicked = {
                    controller.navigate(NavHostRouterPaths.RECORDARY.route)
                }, onCloseSession = {
                    controller.navigate(NavHostRouterPaths.WELCOME.route)
                })
            }
            composable(NavHostRouterPaths.RECORDARY.route) {
                RecordatoryScreen(modifier = Modifier.padding(paddingValue), controller = controller)
            }
        }
    }
}
