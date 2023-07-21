package com.jorgerc.caculatormvvmroom.data.repositories

import android.content.Context
import com.jorgerc.caculatormvvmroom.data.datasources.OperationLocalDataSource
import com.jorgerc.caculatormvvmroom.data.models.OperationDTO
import com.jorgerc.caculatormvvmroom.data.responses.OperationsResponse
import kotlinx.coroutines.flow.flow

class OperationsRepository(context: Context) {

    private val localDataSource: OperationLocalDataSource = OperationLocalDataSource(context)

    fun getOperations() = flow {
        try {
            val operations = localDataSource.getOperation()
            emit(OperationsResponse.Success(operations))
        } catch (e: Exception) {
            emit(OperationsResponse.Error(e.message ?: "Error"))
        }
    }

    fun setOperations(operation: OperationDTO) = flow {
        try {
            emit(OperationsResponse.Success(localDataSource.setOperation(operation)))
        } catch (e: Exception) {
            emit(OperationsResponse.Error(e.message ?: "Error"))
        }
    }

    fun deleteAll() = flow {
        try {
            localDataSource.deleteAll()
            emit(OperationsResponse.Success(listOf()))
        } catch (e: Exception) {
            emit(OperationsResponse.Error(e.message ?: "Error"))
        }
    }
}