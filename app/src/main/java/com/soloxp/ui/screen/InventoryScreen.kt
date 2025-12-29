package com.soloxp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.soloxp.ui.component.DeepBlack
import com.soloxp.ui.component.GlassCard
import com.soloxp.ui.component.LargeHeader

@Composable
fun InventoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlack)
            .padding(16.dp)
    ) {
        LargeHeader(text = "INVENTAIRE", subtext = "Sac de l'Aventurier")
        
        Spacer(modifier = Modifier.height(24.dp))
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(12) {
                GlassCard(isSelected = false, onClick = {}) {
                    Box(modifier = Modifier.size(60.dp))
                }
            }
        }
    }
}
