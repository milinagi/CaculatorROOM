package com.jorgerc.caculatormvvmroom.presentation.screens

import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jorgerc.caculatormvvmroom.R
import com.jorgerc.caculatormvvmroom.data.viewmodels.CalculatorViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(navController: NavController, viewModel: MutableState<CalculatorViewModel>) {


    Column(
    modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Calculator",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.dark_blue)
        )

        Spacer(modifier = Modifier.weight(1f))

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = viewModel.value.display,
            onValueChange = {
                viewModel.value.display = it
            },
            textStyle = TextStyle(
                textAlign = TextAlign.End,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.dark_blue)
            ),
            readOnly = true,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = colorResource(R.color.light_blue)
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(Modifier.padding(bottom = 12.dp)) {
                Divider(
                    modifier = Modifier
                        .weight(3f)
                        .alpha(0f)
                )

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.updateDisplayText()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.red)
                    )
                ) {
                    Text(
                        text = "<-",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Row(Modifier.padding(bottom = 12.dp)) {
                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.resetCalculator()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.red)
                    )
                ) {
                    Text(
                        text = "C",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.applyParenthesis()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_blue)
                    )
                ) {
                    Text(
                        text = "()",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.calculatePercentage()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_blue)
                    )
                ) {
                    Text(
                        text = "%",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendOperator(" / ")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_blue)
                    )
                ) {
                    Text(
                        text = "/",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Row(Modifier.padding(bottom = 12.dp)) {
                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("1")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "1",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("2")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "2",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("3")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "3",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendOperator(" x ")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_blue)
                    )
                ) {
                    Text(
                        text = "x",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Row(Modifier.padding(bottom = 12.dp)) {
                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("4")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "4",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("5")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "5",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("6")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "6",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendOperator(" + ")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_blue)
                    )
                ) {
                    Text(
                        text = "+",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Row(Modifier.padding(bottom = 12.dp)) {
                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("7")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "7",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("8")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "8",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("9")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "9",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendOperator(" - ")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_blue)
                    )
                ) {
                    Text(
                        text = "-",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Row() {
                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendDecimal()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = ".",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("0")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "0",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.appendNumber("000")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.dark_blue)
                    )
                ) {
                    Text(
                        text = "000",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .size(85.dp, 60.dp)
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.value.calculate()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.light_blue)
                    )
                ) {
                    Text(
                        text = "=",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}