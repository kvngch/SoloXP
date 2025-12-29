package com.soloxp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.soloxp.ui.component.DeepBlack
import com.soloxp.ui.component.LargeHeader
import com.soloxp.ui.component.SummaryRow

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlack)
            .padding(16.dp)
    ) {
        LargeHeader(text = "PROFIL", subtext = "Statistiques du Joueur")
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            SummaryRow(label = "Quêtes Terminées", value = "42")
            SummaryRow(label = "Jours de Série", value = "7")
            SummaryRow(label = "Total XP", value = "12450")
            SummaryRow(label = "Mode", value = "Épique")
        }
    }
}
