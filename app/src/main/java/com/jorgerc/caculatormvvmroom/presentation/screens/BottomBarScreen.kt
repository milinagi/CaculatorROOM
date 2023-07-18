package com.jorgerc.caculatormvvmroom.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jorgerc.caculatormvvmroom.presentation.navigation.AppScreens
import com.jorgerc.caculatormvvmroom.presentation.ui.widgets.BottomNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarScreen(navController: NavController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNav(bottomNavController)
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = it.calculateBottomPadding()),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = bottomNavController,
                startDestination = AppScreens.CalculatorScreen.route
            ) {
                composable(route = AppScreens.CalculatorScreen.route) {
                    CalculatorScreen(navController = navController)
                }

                composable(route = AppScreens.HistorialScreen.route) {
                    HistorialScreen(navController = navController)
                }

                composable(route = AppScreens.WipeScreen.route) {
                    WipeScreen(navController = navController)
                }
            }
        }
    }
}