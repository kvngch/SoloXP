package com.soloxp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soloxp.domain.model.Quest
import com.soloxp.ui.component.DeepBlack
import com.soloxp.ui.component.LargeHeader
import com.soloxp.ui.component.NeonCyan

@Composable
fun QuestsScreen(quests: List<Quest>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlack)
            .padding(16.dp)
    ) {
        LargeHeader(text = "LISTE DES QUÊTES", subtext = "Grimoire de Discipline")
        
        Spacer(modifier = Modifier.height(24.dp))
        
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(quests) { quest ->
                QuestCard(quest = quest, neonColor = NeonCyan)
            }
        }
    }
}
