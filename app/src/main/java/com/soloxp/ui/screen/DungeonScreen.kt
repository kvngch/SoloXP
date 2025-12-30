package com.soloxp.ui.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soloxp.domain.model.Quest
import com.soloxp.ui.component.*
import com.soloxp.ui.viewmodel.DungeonViewModel
import com.soloxp.domain.logic.RitualGenerator
import com.soloxp.domain.logic.StreakManager
import com.soloxp.domain.logic.StreakStatus
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DungeonScreen(
    viewModel: DungeonViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val bgColor = DeepBlack
    val neonCyan = NeonCyan
    
    // Bottom Sheet State
    var selectedQuest by remember { mutableStateOf<Quest?>(null) }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    LaunchedEffect(selectedQuest) {
        if (selectedQuest != null) showBottomSheet = true
    }
    
    val profile = uiState.userProfile
    val xpProgress = profile.xpTotal.toFloat() / uiState.xpToNextLevel.toFloat()
    
    // Animate the progress bar
    val animatedProgress by animateFloatAsState(
        targetValue = xpProgress.coerceIn(0f, 1f),
        label = "xpProgress"
    )

    DarkFantasyBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // HUD
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "RANG ${profile.rank}", 
                        color = NeonGold, 
                        fontWeight = FontWeight.Bold, 
                        fontSize = 20.sp,
                        letterSpacing = 2.sp
                    )
                    LinearProgressIndicator(
                        progress = animatedProgress,
                        color = neonCyan,
                        trackColor = Color.White.copy(alpha = 0.1f),
                        modifier = Modifier
                            .width(120.dp)
                            .height(8.dp)
                    )
                    Text(
                        text = "${profile.xpTotal} / ${uiState.xpToNextLevel} XP",
                        color = Color.Gray,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    // Streak Badge
                    if (profile.currentStreak > 0) {
                        val streakBonus = (StreakManager.calculateStreakBonus(profile.currentStreak) * 100).toInt()
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "🔥 ${profile.currentStreak}",
                                color = Color(0xFFFF6B35),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "+$streakBonus%",
                                color = NeonCyan,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                    Text(text = "ÉNERGIE", color = Color.Gray, fontSize = 12.sp)
                    Text(
                        text = "${profile.energyLevel}/10", 
                        color = Color.White, 
                        fontWeight = FontWeight.Black,
                        fontSize = 18.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Portal Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .border(2.dp, Brush.verticalGradient(listOf(neonCyan, Color.Transparent)), RoundedCornerShape(16.dp))
                    .background(Color.White.copy(alpha = 0.02f), RoundedCornerShape(16.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "DONJON DU JOUR",
                        color = neonCyan,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 4.sp
                    )
                    Text(
                        text = "PORTAIL OUVERT", 
                        color = Color.White.copy(alpha = 0.5f),
                        fontSize = 12.sp
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Re-roll Button
                    val haptic = LocalHapticFeedback.current
                    Button(
                        onClick = { 
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            viewModel.rerollQuests() 
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(1.dp, Color.Red.copy(alpha = 0.3f)),
                        shape = RoundedCornerShape(8.dp),
                        enabled = profile.fireCharges > 0,
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "PURGER (${profile.fireCharges} 🔥)", 
                            color = if (profile.fireCharges > 0) Color.Red else Color.Gray,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Daily Ritual Card
            val dailyRitual = RitualGenerator.generateDailyRitual(
                lastCompletedDate = profile.dailyRitualCompletedDate
            )
            if (!dailyRitual.isCompleted) {
                DailyRitualCard(
                    ritual = dailyRitual,
                    onComplete = { viewModel.completeQuest(dailyRitual.quest) }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Text(
                text = "QUÊTES CONSEILLÉES", 
                color = Color.White, 
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp
            )
            
            Spacer(modifier = Modifier.height(12.dp))

            if (uiState.isLoading) {
                CircularProgressIndicator(color = neonCyan, modifier = Modifier.align(Alignment.CenterHorizontally))
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(uiState.dailyQuests) { quest ->
                        QuestCard(
                            quest = quest, 
                            neonColor = if (quest.isCompleted) Color.Gray else neonCyan,
                            onCardClick = { selectedQuest = quest },
                            onComplete = { viewModel.completeQuest(quest) }
                        )
                    }
                }
            }
        }
        
        if (showBottomSheet && selectedQuest != null) {
            ModalBottomSheet(
                onDismissRequest = { 
                    showBottomSheet = false
                    selectedQuest = null 
                },
                sheetState = sheetState,
                containerColor = Color(0xFF1A1A1D)
            ) {
                QuestDetailSheet(
                    quest = selectedQuest!!,
                    onComplete = {
                        viewModel.completeQuest(selectedQuest!!)
                        showBottomSheet = false
                        selectedQuest = null
                    }
                )
            }
        }
    }
}

@Composable
fun QuestCard(
    quest: Quest, 
    neonColor: Color,
    onCardClick: () -> Unit = {},
    onComplete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCardClick() }
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF121214)
        ),
        shape = RoundedCornerShape(12.dp),
        border = if (quest.isCompleted) null else BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(neonColor.copy(alpha = 0.1f), RoundedCornerShape(8.dp))
                    .border(1.dp, neonColor.copy(alpha = 0.3f), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = quest.category.name.take(1), 
                    color = neonColor, 
                    fontWeight = FontWeight.Black
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quest.title, 
                    color = if (quest.isCompleted) Color.Gray else Color.White, 
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "${quest.durationMinutes} MIN • +${quest.xpReward} XP", 
                    color = Color.Gray, 
                    fontSize = 11.sp,
                    letterSpacing = 1.sp
                )
            }
            
            if (!quest.isCompleted) {
                val haptic = LocalHapticFeedback.current
                Button(
                    onClick = { 
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        onComplete() 
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = neonColor),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text(
                        text = "FIXER", 
                        color = Color.Black, 
                        fontSize = 11.sp, 
                        fontWeight = FontWeight.Black
                    )
                }
            } else {
                Text(
                    text = "ACCOMPLI", 
                    color = Color.Gray, 
                    fontSize = 11.sp, 
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun QuestDetailSheet(quest: Quest, onComplete: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .padding(bottom = 32.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = quest.category.name.replace("_", " "),
                color = NeonCyan,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "•   ${quest.difficulty}",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = quest.title,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            lineHeight = 32.sp
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Instructions
        Text(
            text = "CONSIGNE",
            color = Color.Gray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = quest.instructions,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 16.sp,
            lineHeight = 24.sp
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Success Criteria
        Text(
            text = "CONDITION DE SUCCÈS",
            color = Color.Gray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.Top) {
            Text(text = "✓ ", color = NeonCyan, fontSize = 16.sp)
            Text(
                text = quest.successCriteria,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        if (!quest.isCompleted) {
            Button(
                onClick = onComplete,
                colors = ButtonDefaults.buttonColors(containerColor = NeonCyan),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "MISSION ACCOMPLIE (+${quest.xpReward} XP)",
                    color = Color.Black,
                    fontWeight = FontWeight.Black,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun DailyRitualCard(
    ritual: com.soloxp.domain.logic.DailyRitual,
    onComplete: () -> Unit
) {
    val timeRemaining = RitualGenerator.getTimeUntilExpiration(ritual)
    val hoursLeft = TimeUnit.MILLISECONDS.toHours(timeRemaining)
    val minutesLeft = TimeUnit.MILLISECONDS.toMinutes(timeRemaining) % 60
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A0E2E) // Deep purple
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color(0xFF9D4EDD)) // Purple glow
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "👑",
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "RITUEL QUOTIDIEN",
                            color = Color(0xFF9D4EDD),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                        if (ritual.firstClearBonusActive) {
                            Text(
                                text = "FIRST CLEAR BONUS",
                                color = NeonGold,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }
                
                Text(
                    text = "${hoursLeft}h${minutesLeft}m",
                    color = Color.White.copy(alpha = 0.6f),
                    fontSize = 12.sp
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
                text = ritual.quest.title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row {
                Text(
                    text = "${ritual.quest.durationMinutes} MIN",
                    color = Color.Gray,
                    fontSize = 11.sp
                )
                Text(
                    text = " • ",
                    color = Color.Gray,
                    fontSize = 11.sp
                )
                Text(
                    text = "+${ritual.quest.xpReward} XP",
                    color = NeonCyan,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = " • ",
                    color = Color.Gray,
                    fontSize = 11.sp
                )
                Text(
                    text = "LOOT RARE",
                    color = Color(0xFFFFD700),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            val haptic = LocalHapticFeedback.current
            Button(
                onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    onComplete()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9D4EDD)),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "ACCOMPLIR LE RITUEL",
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 14.sp
                )
            }
        }
    }
}
