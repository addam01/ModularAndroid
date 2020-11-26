package com.addam.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.addam.data.models.User

/**
 * Created by addam on 11/26/20
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): LiveData<User>

//    @Query("SELECT * FROM user WHERE username LIKE (:username) LIMIT 1")
//    fun getUser(username: String): Single<User>

//    @Insert()
//    fun insertUser(user: User)
}