package com.jorgerc.caculatormvvmroom.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class OperationDTO (
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    @ColumnInfo val operation: String = "",
    @ColumnInfo val operationResult: String = "",
    @ColumnInfo val date: Long = Date().time
)