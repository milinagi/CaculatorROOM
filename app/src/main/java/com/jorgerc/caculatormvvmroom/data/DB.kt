package com.jorgerc.caculatormvvmroom.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jorgerc.caculatormvvmroom.data.dao.OperationsDao
import com.jorgerc.caculatormvvmroom.data.models.OperationDTO

@Database(entities = [OperationDTO::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun operationDao(): OperationsDao
}