package com.addam.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.addam.data.dao.UserDao
import com.addam.data.models.User

/**
 * Created by addam on 11/26/20
 */
@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}