package com.soloxp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soloxp.domain.model.Quest

@Composable
fun DungeonScreen(
    quests: List<Quest>,
    rank: String = "E",
    xpProgress: Float = 0.3f,
    energyLevel: Int = 5
) {
    val bgColor = Color(0xFF0A0A0B)
    val neonCyan = Color(0xFF00E5FF)
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp)
    ) {
        // HUD
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "RANG $rank", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                LinearProgressIndicator(
                    progress = xpProgress,
                    color = neonCyan,
                    trackColor = Color.DarkGray,
                    modifier = Modifier.width(100.dp).height(8.dp)
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(text = "ÉNERGIE", color = Color.Gray, fontSize = 12.sp)
                Slider(
                    value = energyLevel.toFloat(),
                    onValueChange = {},
                    valueRange = 0f..10f,
                    modifier = Modifier.width(120.dp),
                    colors = SliderDefaults.colors(thumbColor = neonCyan, activeTrackColor = neonCyan)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Portal Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(2.dp, Brush.linearGradient(listOf(neonCyan, Color.Transparent)), RoundedCornerShape(16.dp))
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "DONJON DU JOUR",
                    color = neonCyan,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = "PORTAIL OUVERT", color = Color.White.copy(alpha = 0.7f))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "QUÊTES RECOMMANDÉES", color = Color.White, fontWeight = FontWeight.Bold)
        
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(quests) { quest ->
                QuestCard(quest = quest, neonColor = neonCyan)
            }
        }
    }
}

@Composable
fun QuestCard(quest: Quest, neonColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1C)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(neonColor.copy(alpha = 0.1f), RoundedCornerShape(8.dp))
                    .border(1.dp, neonColor, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                // Placeholder for category icon
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = quest.title, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = "${quest.durationMinutes} min • +${quest.xpReward} XP", color = Color.Gray, fontSize = 12.sp)
            }
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = neonColor),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "DÉMARRER", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
