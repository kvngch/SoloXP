package com.soloxp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soloxp.ui.component.DeepBlack
import com.soloxp.ui.component.LargeHeader
import com.soloxp.ui.component.NeonCyan
import com.soloxp.ui.component.NeonGold

@Composable
fun ProgressScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlack)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LargeHeader(text = "RANG ACTUEL", subtext = "Ascension du Guerrier")
        
        Spacer(modifier = Modifier.height(48.dp))
        
        Text(
            text = "E",
            color = NeonGold,
            fontSize = 120.sp,
            fontWeight = FontWeight.Black
        )
        
        Text(text = "RECRUE", color = Color.Gray, letterSpacing = 4.sp)
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Box(modifier = Modifier.width(200.dp)) {
            LinearProgressIndicator(
                progress = 0.45f,
                color = NeonCyan,
                trackColor = Color.White.copy(alpha = 0.1f),
                modifier = Modifier.fillMaxWidth().height(12.dp)
            )
        }
        
        Text(
            text = "450 / 1000 XP",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
