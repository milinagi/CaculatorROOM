package com.jorgerc.caculatormvvmroom.data.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgerc.caculatormvvmroom.data.models.OperationDTO
import com.jorgerc.caculatormvvmroom.data.repositories.OperationsRepository
import com.jorgerc.caculatormvvmroom.data.responses.OperationsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import java.util.Date

class CalculatorViewModel(context: Context, private val repository: OperationsRepository = OperationsRepository(context)): ViewModel() {
    var display by mutableStateOf(TextFieldValue("0"))
    var firstOperator by mutableStateOf(0.0)
    var secondOperator by mutableStateOf(0.0)
    var result by mutableStateOf(0.0)
    var formattedResult by mutableStateOf("")
    private val mutableStateOperation = MutableStateFlow(OperationViewState())
    val operationViewState: StateFlow<OperationViewState> = mutableStateOperation

    // Operations
    fun calculatePercentage () {
        if (display.text != "0") {
            firstOperator = display.text.toDouble()
            result = firstOperator / 100
            display = TextFieldValue(result.toString())
        }
    }


    fun calculate() {
        if (display.text != "0") {
            if (display.text.contains("+")) {
                if (display.text.split(" + ")[1].isNotEmpty()) {
                    secondOperator = display.text.split(" + ")[1].toDouble()
                    result = firstOperator + secondOperator
                }
            } else if (display.text.contains("-")) {
                if (display.text.split(" - ")[1].isNotEmpty()) {
                    secondOperator = display.text.split(" - ")[1].toDouble()
                    result = firstOperator - secondOperator
                }
            } else if (display.text.contains("x")) {
                if (display.text.split(" x ")[1].isNotEmpty()) {
                    secondOperator = display.text.split(" x ")[1].toDouble()
                    result = firstOperator * secondOperator
                }
            } else if (display.text.contains("/")) {
                if (display.text.split(" / ")[1].isNotEmpty()) {
                    secondOperator = display.text.split(" / ")[1].toDouble()
                    result = firstOperator / secondOperator
                }
            }

            formattedResult = if (result.toInt().toDouble() == result) {
                result.toInt().toString() // Si el resultado es un número entero, convertirlo a cadena sin el decimal .0
            } else {
                result.toString() // Si el resultado tiene decimales, mostrarlo tal como es
            }

            repository.setOperations(
                operation = OperationDTO(
                    operation = display.text,
                    date = Date().time,
                    operationResult = formattedResult
                )
            )
                .flowOn(Dispatchers.IO)
                .launchIn(viewModelScope)

            display = TextFieldValue(formattedResult)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun getOperation() {
        val response = repository.getOperations()
                response.onEach { operationsResponse ->
                    when (operationsResponse) {
                        is OperationsResponse.Success -> {
                            mutableStateOperation.update {
                                it.copy(operations = operationsResponse.operations)
                            }
                        }
                        is OperationsResponse.Error -> {
                            mutableStateOperation.update {
                                it.copy(error = operationsResponse.error)
                            }
                        }
                    }
                }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    // Appends
    fun appendOperator(operator: String) {
        if (display.text != "0" &&
            !display.text.contains("/") &&
            !display.text.contains("+") &&
            !display.text.contains("-") &&
            !display.text.contains("x")
        ) {
            firstOperator = display.text.toDouble()
            display = TextFieldValue(display.text + operator)
        }
    }



    fun appendNumber(number: String) {
        display = if (display.text != "0") {
            TextFieldValue(display.text + number)
        } else {
            TextFieldValue(number)
        }
    }

    fun appendDecimal() {
        if (display.text.matches(Regex(".*\\d$")) && !display.text.contains(".")) {
            display = TextFieldValue(display.text + ".")
        }
    }

    fun updateDisplayText() {
        if (display.text.isNotEmpty()) {
            display = TextFieldValue(display.text.substring(0, display.text.length - 1))

            if (display.text.isEmpty()) {
                display = TextFieldValue("0")
            }
        }
    }

    fun resetCalculator() {     // Functionality onClick 'C' button
        if (display.text != "0") {
            display = TextFieldValue("0")
            firstOperator = 0.0
            secondOperator = 0.0
            formattedResult = ""
        }
    }

    fun applyParenthesis() {    // Functionality onClick '()' button
        if (display.text != "0") {
            display = TextFieldValue("(" + display.text + ")")
        }
    }
}

data class OperationViewState (
    val operations: List<OperationDTO> = listOf(),
    val error: String = ""
        )