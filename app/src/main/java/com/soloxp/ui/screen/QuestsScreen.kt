package com.soloxp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.soloxp.domain.model.Quest
import com.soloxp.ui.component.*
import com.soloxp.ui.viewmodel.QuestsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestsScreen(
    viewModel: QuestsViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val neonCyan = NeonCyan
    
    // Bottom Sheet State
    var selectedQuest by remember { mutableStateOf<Quest?>(null) }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    LaunchedEffect(selectedQuest) {
        if (selectedQuest != null) showBottomSheet = true
    }

    DarkFantasyBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LargeHeader(text = "LISTE DES QUÊTES", subtext = "Grimoire de Discipline")
            
            Spacer(modifier = Modifier.height(24.dp))
            
            if (uiState.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = neonCyan)
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(uiState.quests) { quest ->
                        QuestCard(
                            quest = quest, 
                            neonColor = if (quest.isCompleted) Color.Gray else neonCyan,
                            onCardClick = { selectedQuest = quest },
                            onComplete = {} // QuestsScreen is for viewing, not completing
                        )
                    }
                }
            }
        }
        
        if (showBottomSheet && selectedQuest != null) {
            ModalBottomSheet(
                onDismissRequest = { 
                    showBottomSheet = false
                    selectedQuest = null 
                },
                sheetState = sheetState,
                containerColor = Color(0xFF1A1A1D)
            ) {
                QuestDetailSheet(
                    quest = selectedQuest!!,
                    onComplete = {
                        // In QuestsScreen, we don't complete quests, just view details
                        showBottomSheet = false
                        selectedQuest = null
                    }
                )
            }
        }
    }
}
