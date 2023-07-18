package com.jorgerc.caculatormvvmroom.presentation.navigation

sealed class AppScreens(val route: String) {
    object CalculatorScreen: AppScreens("Calculator_Screen")
    object HistorialScreen: AppScreens("Historial_Screen")
    object WipeScreen: AppScreens("Wipe_Screen")
}