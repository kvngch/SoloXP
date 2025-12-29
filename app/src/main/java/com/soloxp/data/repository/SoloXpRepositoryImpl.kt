package com.soloxp.data.repository

import com.soloxp.data.local.SoloXpDao
import com.soloxp.data.local.dao.ItemDao
import com.soloxp.data.local.entity.QuestEntity
import com.soloxp.data.local.entity.UserProfileEntity
import com.soloxp.data.local.entity.ItemEntity
import com.soloxp.domain.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface SoloXpRepository {
    fun getQuests(): Flow<List<Quest>>
    suspend fun addQuest(quest: Quest)
    suspend fun updateQuest(quest: Quest)
    fun getUserProfile(): Flow<UserProfile?>
    suspend fun saveUserProfile(profile: UserProfile)
    
    // Item Management
    fun getItems(): Flow<List<Item>>
    suspend fun saveItem(item: Item)
    suspend fun deleteItem(item: Item)
    suspend fun getItemById(id: String): Item?
}

class SoloXpRepositoryImpl(
    private val dao: SoloXpDao,
    private val itemDao: ItemDao
) : SoloXpRepository {
    override fun getQuests(): Flow<List<Quest>> = dao.getAllQuests().map { entities ->
        entities.map { it.toDomain() }
    }

    override suspend fun addQuest(quest: Quest) {
        dao.insertQuest(quest.toEntity())
    }

    override suspend fun updateQuest(quest: Quest) {
        dao.insertQuest(quest.toEntity())
    }

    override fun getUserProfile(): Flow<UserProfile?> = dao.getUserProfile().map { it?.toDomain() }

    override suspend fun saveUserProfile(profile: UserProfile) {
        dao.updateUserProfile(profile.toEntity())
    }

    override fun getItems(): Flow<List<Item>> = itemDao.getAllItems().map { entities ->
        entities.map { it.toDomain() }
    }

    override suspend fun saveItem(item: Item) {
        itemDao.insertItem(item.toEntity())
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item.toEntity())
    }

    override suspend fun getItemById(id: String): Item? = itemDao.getItemById(id)?.toDomain()
}

// Mappers
fun QuestEntity.toDomain() = Quest(
    id = id,
    title = title,
    category = QuestCategory.valueOf(category),
    difficulty = Difficulty.valueOf(difficulty),
    durationMinutes = durationMinutes,
    xpReward = xpReward,
    instructions = instructions,
    isCompleted = isCompleted,
    createdAt = createdAt
)

fun Quest.toEntity() = QuestEntity(
    id = id,
    title = title,
    category = category.name,
    difficulty = difficulty.name,
    durationMinutes = durationMinutes,
    xpReward = xpReward,
    instructions = instructions,
    isCompleted = isCompleted,
    createdAt = createdAt
)

fun UserProfileEntity.toDomain() = UserProfile(
    id = id,
    tone = Tone.valueOf(tone),
    energyLevel = energyLevel,
    xpTotal = xpTotal,
    rank = Rank.valueOf(rank),
    fireCharges = fireCharges,
    preferredTimePerDay = preferredTimePerDay
)

fun UserProfile.toEntity() = UserProfileEntity(
    id = id,
    tone = tone.name,
    energyLevel = energyLevel,
    xpTotal = xpTotal,
    rank = rank.name,
    fireCharges = fireCharges,
    preferredTimePerDay = preferredTimePerDay
)

fun ItemEntity.toDomain() = Item(
    id = id,
    name = name,
    description = description,
    rarity = Rarity.valueOf(rarity),
    type = ItemType.valueOf(type),
    icon = icon,
    quantity = quantity,
    addedAt = addedAt
)

fun Item.toEntity() = ItemEntity(
    id = id,
    name = name,
    description = description,
    rarity = rarity.name,
    type = type.name,
    icon = icon,
    quantity = quantity,
    addedAt = addedAt
)
