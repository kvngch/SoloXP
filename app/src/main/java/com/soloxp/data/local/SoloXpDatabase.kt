package com.soloxp.data.local

import androidx.room.*
import com.soloxp.data.local.entity.QuestEntity
import com.soloxp.data.local.entity.UserProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SoloXpDao {
    @Query("SELECT * FROM quests ORDER BY createdAt DESC")
    fun getAllQuests(): Flow<List<QuestEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuest(quest: QuestEntity)

    @Query("SELECT * FROM user_profile WHERE id = 'local_user'")
    fun getUserProfile(): Flow<UserProfileEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserProfile(profile: UserProfileEntity)
}

@Database(entities = [QuestEntity::class, UserProfileEntity::class], version = 1)
abstract class SoloXpDatabase : RoomDatabase() {
    abstract fun dao(): SoloXpDao
}
