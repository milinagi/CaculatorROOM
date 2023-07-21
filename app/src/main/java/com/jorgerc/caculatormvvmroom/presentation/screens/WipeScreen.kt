package com.jorgerc.caculatormvvmroom.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.jorgerc.caculatormvvmroom.data.viewmodels.CalculatorViewModel

@Composable
fun WipeScreen(navController: NavController, viewModel: MutableState<CalculatorViewModel>) {
    Column {
        Text(text = "Wipe...")
    }
}