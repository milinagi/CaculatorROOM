package com.jorgerc.caculatormvvmroom.data.datasources

import android.content.Context
import androidx.room.Room
import com.jorgerc.caculatormvvmroom.data.AppDatabase
import com.jorgerc.caculatormvvmroom.data.models.OperationDTO

class OperationLocalDataSource(context: Context) {

    private val db: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "calculator"
    ).build()

    fun getFunctionList(): List<OperationDTO> {
        return db.operationDao().getAll()
    }

    fun wipeFunctionList(): List<OperationDTO> {
        db.operationDao().save(operation = OperationDTO())
        return db.operationDao().getAll()
    }

    fun getOperation(): List<OperationDTO> {
        return db.operationDao().getAll()
    }

    fun setOperation(operation: OperationDTO): List<OperationDTO> {
        db.operationDao().save(operation = operation)
        return getOperation()
    }
}