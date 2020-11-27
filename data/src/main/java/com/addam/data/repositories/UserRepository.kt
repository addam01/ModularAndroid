package com.addam.data.repositories

import androidx.lifecycle.LiveData
import com.addam.data.dao.UserDao
import com.addam.data.models.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by addam on 11/26/20
 */
@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {
    fun getAllUser(): LiveData<User> = userDao.getUser()

    fun insertUser(user: User) = userDao.insertUser(user)

}