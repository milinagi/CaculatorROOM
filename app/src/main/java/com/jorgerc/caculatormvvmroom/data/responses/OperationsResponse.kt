package com.jorgerc.caculatormvvmroom.data.responses

import com.jorgerc.caculatormvvmroom.data.models.OperationDTO

sealed class OperationsResponse {
    data class Success(val operation: List<OperationDTO>): OperationsResponse()
    data class Error(val error: String): OperationsResponse()
}