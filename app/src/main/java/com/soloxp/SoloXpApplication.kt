package com.soloxp

import android.app.Application
import androidx.room.Room
import com.soloxp.data.local.SoloXpDatabase
import com.soloxp.data.repository.SoloXpRepository
import com.soloxp.data.repository.SoloXpRepositoryImpl

class SoloXpApplication : Application() {
    val database: SoloXpDatabase by lazy {
        Room.databaseBuilder(this, SoloXpDatabase::class.java, "soloxp_database")
            .fallbackToDestructiveMigration()
            .build()
    }
    
    val repository: SoloXpRepository by lazy {
        SoloXpRepositoryImpl(database.dao())
    }
}
