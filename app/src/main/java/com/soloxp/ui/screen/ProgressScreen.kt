package com.soloxp.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soloxp.ui.component.*
import com.soloxp.ui.viewmodel.ProgressViewModel

@Composable
fun ProgressScreen(
    viewModel: ProgressViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    val xpProgress = if (uiState.xpToNextLevel > 0) {
        uiState.totalXp.toFloat() / uiState.xpToNextLevel.toFloat()
    } else 0f
    
    val animatedProgress by animateFloatAsState(
        targetValue = xpProgress.coerceIn(0f, 1f),
        label = "progress"
    )

    DarkFantasyBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LargeHeader(text = "RANG ACTUEL", subtext = "Ascension du Guerrier")
            
            Spacer(modifier = Modifier.height(48.dp))
            
            Text(
                text = uiState.currentRank.name,
                color = NeonGold,
                fontSize = 120.sp,
                fontWeight = FontWeight.Black
            )
            
            Text(
                text = "RANG ${uiState.currentRank}",
                color = Color.Gray,
                letterSpacing = 4.sp
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Box(modifier = Modifier.width(240.dp)) {
                LinearProgressIndicator(
                    progress = animatedProgress,
                    color = NeonCyan,
                    trackColor = Color.White.copy(alpha = 0.1f),
                    modifier = Modifier.fillMaxWidth().height(12.dp).clip(RoundedCornerShape(6.dp))
                )
            }
            
            Text(
                text = "${uiState.totalXp} / ${uiState.xpToNextLevel} XP",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            
            Spacer(modifier = Modifier.height(48.dp))
            
            // Artifact Resonance Section
            GlassCard(isSelected = false, onClick = {}) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "RÉSONANCE ARTEFACT",
                        color = NeonCyan,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "+${(uiState.artifactResonance * 100).toInt()}% XP BOOST",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Bonus passif actif",
                        color = Color.Gray,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}
