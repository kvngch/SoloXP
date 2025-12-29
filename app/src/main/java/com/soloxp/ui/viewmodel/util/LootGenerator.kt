package com.soloxp.ui.viewmodel.util

import com.soloxp.domain.model.*
import java.util.UUID
import kotlin.random.Random

object LootGenerator {
    
    fun generateLoot(difficulty: Difficulty): Item? {
        val dropChance = when (difficulty) {
            Difficulty.MICRO -> 0.10 // 10%
            Difficulty.MINI -> 0.20 // 20%
            Difficulty.STANDARD -> 0.30 // 30%
            Difficulty.BOSS -> 1.00 // 100%
        }
        
        if (Random.nextDouble() > dropChance) return null
        
        val rarity = when {
            difficulty == Difficulty.BOSS -> {
                if (Random.nextDouble() < 0.2) Rarity.LEGENDARY else Rarity.RARE
            }
            Random.nextDouble() < 0.05 -> Rarity.LEGENDARY
            Random.nextDouble() < 0.20 -> Rarity.RARE
            else -> Rarity.COMMON
        }
        
        return createRandomItem(rarity)
    }
    
    private fun createRandomItem(rarity: Rarity): Item {
        val id = UUID.randomUUID().toString()
        return when (rarity) {
            Rarity.COMMON -> Item(
                id = id,
                name = "Fragment de Lumière",
                description = "Un petit éclat brillant. Utile pour la forge.",
                rarity = Rarity.COMMON,
                type = ItemType.ARTIFACT,
                icon = "✨"
            )
            Rarity.RARE -> Item(
                id = id,
                name = "Essence de Feu",
                description = "Restaure instantanément une Charge de Feu.",
                rarity = Rarity.RARE,
                type = ItemType.CONSUMABLE,
                icon = "🔥"
            )
            Rarity.LEGENDARY -> Item(
                id = id,
                name = "Relique de l'Immortel",
                description = "Un artefact d'une puissance inouïe. Augmente votre aura.",
                rarity = Rarity.LEGENDARY,
                type = ItemType.ARTIFACT,
                icon = "🔱"
            )
        }
    }
}
