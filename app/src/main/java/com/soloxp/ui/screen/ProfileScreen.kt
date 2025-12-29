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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soloxp.domain.model.QuestCategory
import com.soloxp.ui.component.*
import com.soloxp.ui.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val profile = uiState.userProfile

    DarkFantasyBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
        LargeHeader(text = "RÉSILIENCE", subtext = "Archive of the Immortal")
        
        Spacer(modifier = Modifier.height(32.dp))

        // Profile Stats Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0.05f), RoundedCornerShape(16.dp))
                .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(16.dp))
                .padding(24.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "RANG ${profile.rank}", 
                    color = NeonGold, 
                    fontSize = 28.sp, 
                    fontWeight = FontWeight.Black,
                    letterSpacing = 4.sp
                )
                Text(
                    text = "${profile.xpTotal} XP ACCUMULÉ", 
                    color = Color.Gray, 
                    fontSize = 12.sp,
                    letterSpacing = 2.sp
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatBox(label = "FEU", value = "${profile.fireCharges}", color = Color.Red)
                    StatBox(label = "ÉNERGIE", value = "${profile.energyLevel}/10", color = NeonCyan)
                    StatBox(label = "QUÊTES", value = "${uiState.totalQuestsCompleted}", color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "DOMAINES DE MAÎTRISE", 
            color = Color.White, 
            fontWeight = FontWeight.ExtraBold,
            fontSize = 14.sp
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val categories = QuestCategory.values()
            items(categories) { category ->
                val count = uiState.categoryStats[category] ?: 0
                SummaryRow(
                    label = category.name,
                    value = "$count QUÊTES"
                )
            }
        }
        }
    }
}

@Composable
fun StatBox(label: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, color = Color.Gray, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        Text(text = value, color = color, fontSize = 18.sp, fontWeight = FontWeight.Black)
    }
}
