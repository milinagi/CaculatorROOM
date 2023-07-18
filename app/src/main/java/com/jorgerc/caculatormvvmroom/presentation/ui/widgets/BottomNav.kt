package com.jorgerc.caculatormvvmroom.presentation.ui.widgets

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jorgerc.caculatormvvmroom.presentation.navigation.AppScreens

@Composable
fun BottomNav(navController: NavHostController) {
    BottomNavigation() {
        Button(
            //modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate(AppScreens.HistorialScreen.route)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(text = "Historial")
        }

        Button(
            //modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate(AppScreens.CalculatorScreen.route)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(text = "Calculadora")
        }

        Button(
            //modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate(AppScreens.WipeScreen.route)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(text = "Borrar")
        }
    }
}