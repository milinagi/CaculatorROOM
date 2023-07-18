package com.jorgerc.caculatormvvmroom.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jorgerc.caculatormvvmroom.data.models.OperationDTO

@Dao
interface OperationsDao {
    @Query("SELECT * FROM OperationDTO")
    fun getAll(): List<OperationDTO>

    @Insert
    fun save(operation: OperationDTO)

    @Delete
    fun delete(operation: OperationDTO)

    @Query("DELETE FROM OperationDTO")
    fun deleteAll()
}
