package com.jorgerc.caculatormvvmroom.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.jorgerc.caculatormvvmroom.data.viewmodels.CalculatorViewModel

@Composable
fun WipeScreen(navController: NavController, viewModel: MutableState<CalculatorViewModel>) {

//    LaunchedEffect(Unit) {
//        viewModel.value.deleteAll()
//    }
    Column {
        Button(onClick = {
            viewModel.value.deleteAll()
        }) {
            Text(text = "Borrar TODO...")
        }
    }
}