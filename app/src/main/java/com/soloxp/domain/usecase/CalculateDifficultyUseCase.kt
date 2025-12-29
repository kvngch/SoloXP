package com.soloxp.domain.usecase

import com.soloxp.domain.model.Difficulty
import com.soloxp.domain.model.UserProfile
import kotlin.math.max
import kotlin.math.min

class CalculateDifficultyUseCase {
    /**
     * Calculates the target difficulty based on user energy and success history.
     * Logic:
     * - Energy <= 3: MICRO or MINI only.
     * - High success rate (>70%): Increase difficulty.
     * - Recent failure/Low recovery: Propose Low Energy Pack (MICRO).
     */
    fun execute(userProfile: UserProfile, last7DaysSuccessRate: Float): Difficulty {
        if (userProfile.energyLevel <= 3) return Difficulty.MICRO
        
        return when {
            last7DaysSuccessRate > 0.8f -> Difficulty.STANDARD
            last7DaysSuccessRate < 0.3f -> Difficulty.MICRO
            else -> Difficulty.MINI
        }
    }
}
