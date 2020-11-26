package com.addam.data

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by addam on 11/26/20
 *
 * Here is where you add the Dao for Injection of the DAOs. For every DAO added, need to create
 * 1. Model
 * 2. Dao class
 * 3. Repositories
 * 4. Add to DatabaseProvider for the DAO
 * 5. Add here the DAO also
 */
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase{
        return Room.databaseBuilder(application, AppDatabase::class.java, "dbProvider")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesUserDao(db: AppDatabase) = db.userDao()
}