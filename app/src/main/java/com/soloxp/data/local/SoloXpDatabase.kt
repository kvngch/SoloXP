package com.soloxp.data.local

import androidx.room.*
import com.soloxp.data.local.entity.QuestEntity
import com.soloxp.data.local.entity.UserProfileEntity
import kotlinx.coroutines.flow.Flow

import com.soloxp.data.local.entity.ItemEntity
import com.soloxp.data.local.dao.ItemDao

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

@Database(
    entities = [QuestEntity::class, UserProfileEntity::class, ItemEntity::class],
    version = 5
)
abstract class SoloXpDatabase : RoomDatabase() {
    abstract fun dao(): SoloXpDao
    abstract fun itemDao(): ItemDao

    companion object {
        val MIGRATION_2_3 = object : androidx.room.migration.Migration(2, 3) {
            override fun migrate(database: androidx.sqlite.db.SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE quests ADD COLUMN successCriteria TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_3_4 = object : androidx.room.migration.Migration(3, 4) {
            override fun migrate(database: androidx.sqlite.db.SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user_profile ADD COLUMN activeTitle TEXT NOT NULL DEFAULT 'NEOPHYTE'")
                database.execSQL("ALTER TABLE user_profile ADD COLUMN unlockedTitles TEXT NOT NULL DEFAULT 'NEOPHYTE'")
                database.execSQL("ALTER TABLE user_profile ADD COLUMN skillPoints INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE user_profile ADD COLUMN unlockedSkills TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_4_5 = object : androidx.room.migration.Migration(4, 5) {
            override fun migrate(database: androidx.sqlite.db.SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user_profile ADD COLUMN currentStreak INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE user_profile ADD COLUMN longestStreak INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE user_profile ADD COLUMN lastQuestCompletedDate INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE user_profile ADD COLUMN streakSaverUsed INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE user_profile ADD COLUMN dailyRitualCompletedDate INTEGER NOT NULL DEFAULT 0")
            }
        }
    }
}
