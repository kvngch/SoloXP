package com.soloxp.ui.screen

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soloxp.domain.model.QuestCategory
import com.soloxp.ui.component.*
import com.soloxp.ui.viewmodel.OnboardingUiState
import com.soloxp.ui.viewmodel.OnboardingViewModel

@Composable
fun OnboardingScreen(onFinish: () -> Unit, viewModel: OnboardingViewModel = viewModel()) {
    var step by remember { mutableIntStateOf(1) }
    val uiState by viewModel.uiState.collectAsState()

    DarkFantasyBackground {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            
            AnimatedContent(
                targetState = step,
                transitionSpec = {
                    slideInHorizontally { it } + fadeIn() togetherWith
                            slideOutHorizontally { -it } + fadeOut()
                },
                label = "step_transition"
            ) { currentStep ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    when (currentStep) {
                        1 -> WelcomeStep()
                        2 -> EnergyStep(uiState.energyLevel, viewModel::updateEnergyLevel)
                        3 -> GoalsStep(uiState.selectedGoals, viewModel::toggleGoal)
                        4 -> TimeStep(uiState.availableTimeMinutes, viewModel::updateAvailableTime)
                        5 -> SummaryStep(uiState)
                    }
                }
            }
        }

        val haptic = LocalHapticFeedback.current
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ActionButton(
                text = if (step < 5) "CONTINUER" else "SCELER MON DESTIN",
                onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    if (step < 5) step++ else {
                        viewModel.completeOnboarding { onFinish() }
                    }
                }
            )

            if (step > 1) {
                Spacer(modifier = Modifier.height(12.dp))
                TextButton(
                    onClick = {
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        step--
                    }
                ) {
                    Text(
                        text = "RETOUR",
                        color = Color.White.copy(alpha = 0.5f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }
            }
        }
    }
}
}

@Composable
fun WelcomeStep() {
    LargeHeader(text = "SOLO XP", subtext = "Bienvenue, Voyageur")
    Spacer(modifier = Modifier.height(32.dp))
    Text(
        "Forger une discipline est un combat quotidien.\nIci, chaque action est une quête.\nChaque jour est un niveau.",
        color = Color.White.copy(alpha = 0.7f),
        textAlign = TextAlign.Center,
        lineHeight = 24.sp,
        fontSize = 16.sp
    )
}

@Composable
fun EnergyStep(currentLevel: Int, onLevelChange: (Int) -> Unit) {
    LargeHeader(text = "TON ÉNERGIE", subtext = "État des troupes")
    Spacer(modifier = Modifier.height(48.dp))
    
    Text(
        text = when {
            currentLevel < 3 -> "EXTÉNUÉ"
            currentLevel < 7 -> "OPÉRATIONNEL"
            else -> "EN FEU"
        },
        color = NeonCyan,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp
    )
    
    Slider(
        value = currentLevel.toFloat(),
        onValueChange = { onLevelChange(it.toInt()) },
        valueRange = 1f..10f,
        steps = 8,
        colors = SliderDefaults.colors(
            thumbColor = NeonCyan,
            activeTrackColor = NeonCyan,
            inactiveTrackColor = Color.White.copy(alpha = 0.1f)
        ),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp)
    )
}

@Composable
fun GoalsStep(selected: Set<QuestCategory>, onToggle: (QuestCategory) -> Unit) {
    LargeHeader(text = "VOS PRIORITÉS", subtext = "Objectifs de Campagne")
    Spacer(modifier = Modifier.height(24.dp))
    
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(QuestCategory.values()) { category ->
            val haptic = LocalHapticFeedback.current
            GlassCard(
                isSelected = selected.contains(category),
                onClick = { 
                    haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                    onToggle(category) 
                }
            ) {
                Text(
                    text = category.name.replace("_", " "),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun TimeStep(currentTime: Int, onTimeChange: (Int) -> Unit) {
    LargeHeader(text = "TEMPS DISPO", subtext = "Fenêtre d'Action")
    Spacer(modifier = Modifier.height(32.dp))
    
    val options = listOf(5, 15, 30, 60)
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        options.forEach { minutes ->
            val haptic = LocalHapticFeedback.current
            GlassCard(
                isSelected = currentTime == minutes,
                onClick = { 
                    haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                    onTimeChange(minutes) 
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "$minutes MINUTES / JOUR",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun SummaryStep(state: OnboardingUiState) {
    LargeHeader(text = "RANG E", subtext = "Profil de Recrue")
    Spacer(modifier = Modifier.height(32.dp))
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White.copy(alpha = 0.05f), RoundedCornerShape(12.dp))
            .padding(24.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            SummaryRow("Énergie", "${state.energyLevel}/10")
            SummaryRow("Objectifs", "${state.selectedGoals.size} actifs")
            SummaryRow("Disponibilité", "${state.availableTimeMinutes} min")
        }
    }
}

