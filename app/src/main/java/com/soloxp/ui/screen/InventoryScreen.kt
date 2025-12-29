package com.soloxp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soloxp.domain.model.*
import com.soloxp.ui.component.*
import com.soloxp.ui.viewmodel.InventoryViewModel

@Composable
fun InventoryScreen(
    viewModel: InventoryViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedItem by remember { mutableStateOf<Item?>(null) }

    DarkFantasyBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LargeHeader(text = "L'ARSENAL", subtext = "Archive of your Conquests")
            
            Spacer(modifier = Modifier.height(24.dp))
            
            if (uiState.items.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "VOTRE SAC EST VIDE.\nCOMPLÉTEZ DES QUÊTES POUR RÉCOLTER DU BUTIN.",
                        color = Color.Gray.copy(alpha = 0.5f),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        letterSpacing = 2.sp
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(uiState.items) { item ->
                        ItemSlot(
                            item = item,
                            isSelected = selectedItem?.id == item.id,
                            onClick = { selectedItem = item }
                        )
                    }
                }
                
                selectedItem?.let { item ->
                    ItemDetails(
                        item = item,
                        onUse = { 
                            viewModel.useItem(item)
                            selectedItem = null
                        },
                        onClose = { selectedItem = null }
                    )
                }
            }
        }
    }
}

@Composable
fun ItemSlot(item: Item, isSelected: Boolean, onClick: () -> Unit) {
    val rarityColor = when (item.rarity) {
        Rarity.COMMON -> Color.Gray
        Rarity.RARE -> NeonCyan
        Rarity.LEGENDARY -> NeonGold
    }

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.05f))
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = if (isSelected) rarityColor else Color.White.copy(alpha = 0.1f),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = item.icon, fontSize = 24.sp)
            if (item.quantity > 1) {
                Text(
                    text = "x${item.quantity}",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ItemDetails(item: Item, onUse: () -> Unit, onClose: () -> Unit) {
    val rarityColor = when (item.rarity) {
        Rarity.COMMON -> Color.Gray
        Rarity.RARE -> NeonCyan
        Rarity.LEGENDARY -> NeonGold
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black.copy(alpha = 0.8f))
            .border(1.dp, rarityColor.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name.uppercase(),
                    color = rarityColor,
                    fontWeight = FontWeight.Black,
                    fontSize = 18.sp,
                    letterSpacing = 2.sp
                )
                Text(
                    text = item.rarity.name,
                    color = rarityColor.copy(alpha = 0.5f),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = item.description,
                color = Color.LightGray,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                if (item.type == ItemType.CONSUMABLE) {
                    Button(
                        onClick = onUse,
                        colors = ButtonDefaults.buttonColors(containerColor = NeonCyan),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("UTILISER", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
                OutlinedButton(
                    onClick = onClose,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("FERMER", color = Color.White)
                }
            }
        }
    }
}
