package com.soloxp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SupportCenterScreen(onBack: () -> Unit) {
    val bgColor = Color(0xFF0A0A0B)
    val warningRed = Color(0xFFFF5252)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(24.dp)
    ) {
        Text("CENTRE DE SOUTIEN", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            colors = CardDefaults.cardColors(containerColor = warningRed.copy(alpha = 0.1f)),
            modifier = Modifier.fillMaxWidth().border(1.dp, warningRed, RoundedCornerShape(12.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("JE NE VAIS PAS BIEN", color = warningRed, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Si tu as des idées suicidaires ou si tu es en danger immédiat, s'il te plaît, contacte de l'aide maintenant.",
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Call emergency icon/action */ },
                    colors = ButtonDefaults.buttonColors(containerColor = warningRed),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("APPELER LES URGENCES (15/112)", color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("RESSOURCES UTILES", color = Color.White, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        
        ResourceItem("Fil Santé Jeunes", "0 800 235 236")
        ResourceItem("SOS Amitié", "09 72 39 40 50")
        ResourceItem("Suicide Écoute", "01 45 39 40 00")

        Spacer(modifier = Modifier.weight(1f))
        
        TextButton(onClick = onBack, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("RETOUR", color = Color.Gray)
        }
    }
}

@Composable
fun ResourceItem(name: String, number: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(name, color = Color.White)
        Text(number, color = Color(0xFF00E5FF), fontWeight = FontWeight.Bold)
    }
}
