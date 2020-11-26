package com.addam.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by addam on 11/26/20
 */
@Entity(tableName = "user")
data class User (
        @PrimaryKey var username: String,
        @ColumnInfo(name = "password") var password: String
)