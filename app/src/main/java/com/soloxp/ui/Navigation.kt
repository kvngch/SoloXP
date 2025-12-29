package com.soloxp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Dungeon : Screen("dungeon", "Donjon", Icons.Default.Home)
    object Quests : Screen("quests", "Quests", Icons.Default.List)
    object Progress : Screen("progress", "Rang", Icons.Default.Star)
    object Inventory : Screen("inventory", "Sac", Icons.Default.Settings)
    object Profile : Screen("profile", "Moi", Icons.Default.Person)
}

val bottomNavItems = listOf(
    Screen.Dungeon,
    Screen.Quests,
    Screen.Progress,
    Screen.Inventory,
    Screen.Profile
)
