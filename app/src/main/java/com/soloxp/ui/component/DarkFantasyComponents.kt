package com.soloxp.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Enhanced Color Palette
val NeonCyan = Color(0xFF00E5FF)
val NeonGold = Color(0xFFFFD700)
val NeonPurple = Color(0xFF9D4EDD)
val NeonRed = Color(0xFFFF6B35)
val DeepBlack = Color(0xFF0A0A0B)
val DarkGrey = Color(0xFF121214)
val MidGrey = Color(0xFF1A1A1D)
val SoftGlow = Color(0xFF1E1E21)

// Gradient Presets
val CyanGradient = listOf(Color(0xFF00E5FF), Color(0xFF0099CC))
val GoldGradient = listOf(Color(0xFFFFD700), Color(0xFFFF8C00))
val PurpleGradient = listOf(Color(0xFF9D4EDD), Color(0xFF6A0DAD))
val RedGradient = listOf(Color(0xFFFF6B35), Color(0xFFDC2626))

@Composable
fun DarkFantasyBackground(content: @Composable BoxScope.() -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "embers")
    
    // Multiple particles with varied speeds
    val ember1Y by infiniteTransition.animateFloat(
        initialValue = 1000f,
        targetValue = -100f,
        animationSpec = infiniteRepeatable(
            animation = tween(15000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ember1"
    )
    
    val ember2Y by infiniteTransition.animateFloat(
        initialValue = 1000f,
        targetValue = -100f,
        animationSpec = infiniteRepeatable(
            animation = tween(20000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ember2"
    )
    
    val ember3Y by infiniteTransition.animateFloat(
        initialValue = 1000f,
        targetValue = -100f,
        animationSpec = infiniteRepeatable(
            animation = tween(18000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "ember3"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0A0A0B),
                        Color(0xFF121214),
                        DeepBlack
                    )
                )
            )
    ) {
        androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
            // Cyan particles (foreground)
            drawCircle(
                color = NeonCyan.copy(alpha = 0.15f),
                radius = 8f,
                center = Offset(size.width * 0.15f, ember1Y % size.height)
            )
            drawCircle(
                color = NeonCyan.copy(alpha = 0.08f),
                radius = 5f,
                center = Offset(size.width * 0.75f, (ember2Y * 0.7f) % size.height)
            )
            
            // Gold particles (midground)
            drawCircle(
                color = NeonGold.copy(alpha = 0.1f),
                radius = 6f,
                center = Offset(size.width * 0.5f, (ember3Y * 0.9f) % size.height)
            )
            
            // Red particles (background)
            drawCircle(
                color = NeonRed.copy(alpha = 0.05f),
                radius = 4f,
                center = Offset(size.width * 0.85f, (ember1Y * 1.2f) % size.height)
            )
            drawCircle(
                color = Color.Red.copy(alpha = 0.04f),
                radius = 3f,
                center = Offset(size.width * 0.3f, (ember2Y * 1.1f) % size.height)
            )
        }
        content()
    }
}

@Composable
fun GlassCard(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    glowColor: Color = NeonCyan,
    content: @Composable ColumnScope.() -> Unit
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.02f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale"
    )
    val borderColor by animateColorAsState(
        targetValue = if (isSelected) glowColor else Color.White.copy(alpha = 0.1f),
        label = "border"
    )

    Box(
        modifier = modifier
            .scale(scale)
            .shadow(
                elevation = if (isSelected) 8.dp else 2.dp,
                shape = RoundedCornerShape(16.dp),
                ambientColor = if (isSelected) glowColor.copy(alpha = 0.4f) else Color.Transparent,
                spotColor = if (isSelected) glowColor.copy(alpha = 0.3f) else Color.Transparent
            )
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .background(
                Brush.verticalGradient(
                    colors = if (isSelected) {
                        listOf(
                            Color.White.copy(alpha = 0.15f),
                            Color.White.copy(alpha = 0.05f)
                        )
                    } else {
                        listOf(
                            Color.White.copy(alpha = 0.08f),
                            Color.White.copy(alpha = 0.02f)
                        )
                    }
                )
            )
            .border(
                width = if (isSelected) 1.5.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
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
                color = Color.Gray.copy(alpha = 0.7f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 3.sp
            )
        }
        Text(
            text = text,
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            lineHeight = 38.sp,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.White.copy(alpha = 0.3f),
                    offset = Offset(0f, 2f),
                    blurRadius = 4f
                )
            )
        )
    }
}

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    gradient: List<Color> = CyanGradient
) {
    val scale by animateFloatAsState(
        targetValue = if (enabled) 1f else 0.95f,
        label = "buttonScale"
    )
    
    Surface(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .scale(scale)
            .shadow(
                elevation = if (enabled) 8.dp else 2.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = if (enabled) gradient.first().copy(alpha = 0.4f) else Color.Transparent
            )
            .clip(RoundedCornerShape(12.dp)),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier.background(
                if (enabled) {
                    Brush.horizontalGradient(gradient)
                } else {
                    Brush.horizontalGradient(listOf(Color.DarkGray, Color.DarkGray))
                }
            ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text.uppercase(),
                color = if (enabled) Color.Black else Color.Gray,
                fontWeight = FontWeight.Black,
                letterSpacing = 2.sp,
                fontSize = 14.sp,
                style = if (enabled) {
                    TextStyle(
                        shadow = Shadow(
                            color = Color.Black.copy(alpha = 0.3f),
                            offset = Offset(0f, 1f),
                            blurRadius = 2f
                        )
                    )
                } else {
                    TextStyle()
                }
            )
        }
    }
}

@Composable
fun SummaryRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = Color.Gray.copy(alpha = 0.8f),
            fontSize = 14.sp
        )
        Text(
            text = value,
            color = NeonCyan,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            style = TextStyle(
                shadow = Shadow(
                    color = NeonCyan.copy(alpha = 0.5f),
                    offset = Offset(0f, 0f),
                    blurRadius = 4f
                )
            )
        )
    }
}

// New Typography Components
@Composable
fun DisplayText(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 48.sp,
        fontWeight = FontWeight.Black,
        letterSpacing = 2.sp,
        color = color,
        modifier = modifier,
        style = TextStyle(
            shadow = Shadow(
                color = color.copy(alpha = 0.5f),
                offset = Offset(0f, 4f),
                blurRadius = 8f
            )
        )
    )
}

@Composable
fun TitleText(
    text: String,
    color: Color = NeonCyan,
    modifier: Modifier = Modifier
) {
    Text(
        text = text.uppercase(),
        fontSize = 14.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 3.sp,
        color = color,
        modifier = modifier
    )
}

@Composable
fun BodyText(
    text: String,
    color: Color = Color.White.copy(alpha = 0.8f),
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        color = color,
        modifier = modifier
    )
}

// Animated Progress Bar
@Composable
fun AnimatedProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    gradient: List<Color> = CyanGradient,
    showPercentage: Boolean = false
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "progress"
    )
    
    Box(modifier = modifier) {
        // Background track
        Box(
            Modifier
                .fillMaxWidth()
                .height(12.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White.copy(alpha = 0.05f))
        )
        
        // Animated fill with gradient + glow
        Box(
            Modifier
                .fillMaxWidth(animatedProgress)
                .height(12.dp)
                .clip(RoundedCornerShape(6.dp))
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(6.dp),
                    ambientColor = gradient.first().copy(alpha = 0.6f)
                )
                .background(
                    Brush.horizontalGradient(gradient)
                )
        )
        
        if (showPercentage) {
            Text(
                text = "${(animatedProgress * 100).toInt()}%",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
