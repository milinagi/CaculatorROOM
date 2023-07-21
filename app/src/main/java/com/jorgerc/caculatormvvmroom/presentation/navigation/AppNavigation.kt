package com.jorgerc.caculatormvvmroom.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jorgerc.caculatormvvmroom.data.viewmodels.CalculatorViewModel
import com.jorgerc.caculatormvvmroom.presentation.screens.BottomBarScreen
import com.jorgerc.caculatormvvmroom.presentation.screens.CalculatorScreen
import com.jorgerc.caculatormvvmroom.presentation.screens.HistorialScreen
import com.jorgerc.caculatormvvmroom.presentation.screens.WipeScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.BottomBarScreen.route )
    {
        composable(route = AppScreens.BottomBarScreen.route) {
//            CalculatorScreen(navController = navController, viewModel = viewModel)
            BottomBarScreen(navController = navController)
        }
//        composable(route = AppScreens.HistorialScreen.route) {
//           HistorialScreen(navController = navController, viewModel = viewModel)
//            BottomBarScreen(navController = navController)
//        }
//        composable(route = AppScreens.WipeScreen.route) {
//            WipeScreen(navController = navController, viewModel = viewModel)
//            BottomBarScreen(navController = navController)
//        }
    }
}