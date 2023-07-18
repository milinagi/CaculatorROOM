package com.jorgerc.caculatormvvmroom.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jorgerc.caculatormvvmroom.presentation.screens.BottomBarScreen
import com.jorgerc.caculatormvvmroom.presentation.screens.CalculatorScreen
import com.jorgerc.caculatormvvmroom.presentation.screens.HistorialScreen
import com.jorgerc.caculatormvvmroom.presentation.screens.WipeScreen

@Preview
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.CalculatorScreen.route )
    {
        composable(route = AppScreens.CalculatorScreen.route) {
            CalculatorScreen(navController = navController)
            BottomBarScreen(navController = navController)
        }
        composable(route = AppScreens.HistorialScreen.route) {
            HistorialScreen(navController = navController)
            BottomBarScreen(navController = navController)
        }
        composable(route = AppScreens.WipeScreen.route) {
            WipeScreen(navController = navController)
            BottomBarScreen(navController = navController)
        }
    }
}