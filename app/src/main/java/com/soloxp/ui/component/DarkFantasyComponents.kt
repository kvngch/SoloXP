package com.soloxp.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val NeonCyan = Color(0xFF00E5FF)
val NeonGold = Color(0xFFFFD700)
val DarkGrey = Color(0xFF121214)
val DeepBlack = Color(0xFF0A0A0B)

@Composable
fun GlassCard(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val scale by animateFloatAsState(if (isSelected) 1.05f else 1f, label = "scale")
    val borderColor by animateColorAsState(if (isSelected) NeonCyan else Color.White.copy(alpha = 0.1f), label = "border")
    val glowAlpha by animateFloatAsState(if (isSelected) 0.5f else 0f, label = "glow")

    Box(
        modifier = modifier
            .scale(scale)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.1f),
                        Color.White.copy(alpha = 0.02f)
                    )
                )
            )
            .border(1.dp, borderColor, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Column(content = content)
    }
}

@Composable
fun LargeHeader(text: String, subtext: String? = null) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (subtext != null) {
            Text(
                text = subtext.uppercase(),
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
        }
        Text(
            text = text,
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            lineHeight = 38.sp
        )
    }
}

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Surface(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp)),
        color = if (enabled) NeonCyan else Color.DarkGray
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text.uppercase(),
                color = if (enabled) Color.Black else Color.Gray,
                fontWeight = FontWeight.Black,
                letterSpacing = 1.sp
            )
        }
    }
}
@Composable
fun SummaryRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color.Gray)
        Text(value, color = NeonCyan, fontWeight = FontWeight.Bold)
    }
}
