package com.soloxp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.soloxp.ui.Screen
import com.soloxp.ui.bottomNavItems
import com.soloxp.ui.component.DeepBlack
import com.soloxp.ui.component.NeonCyan
import com.soloxp.ui.screen.*
import com.soloxp.ui.theme.Typography
import com.soloxp.ui.viewmodel.DungeonViewModel
import com.soloxp.ui.viewmodel.OnboardingViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val repository = (application as SoloXpApplication).repository

        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    primary = NeonCyan,
                    background = DeepBlack,
                    surface = DeepBlack
                ),
                typography = Typography
            ) {
                var showOnboarding by remember { mutableStateOf(true) }
                val navController = rememberNavController()

                if (showOnboarding) {
                    val onboardingViewModel: OnboardingViewModel = viewModel(
                        factory = object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return OnboardingViewModel(repository) as T
                            }
                        }
                    )
                    OnboardingScreen(
                        viewModel = onboardingViewModel,
                        onFinish = { showOnboarding = false }
                    )
                } else {
                    Scaffold(
                        bottomBar = {
                            NavigationBar(
                                containerColor = Color(0xFF121214),
                                contentColor = Color.White
                            ) {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentDestination = navBackStackEntry?.destination
                                
                                bottomNavItems.forEach { screen ->
                                    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                                    
                                    NavigationBarItem(
                                        icon = { 
                                            Icon(
                                                imageVector = screen.icon, 
                                                contentDescription = screen.title,
                                                tint = if (selected) NeonCyan else Color.Gray
                                            ) 
                                        },
                                        label = { 
                                            Text(
                                                text = screen.title,
                                                color = if (selected) NeonCyan else Color.Gray
                                            ) 
                                        },
                                        selected = selected,
                                        onClick = {
                                            navController.navigate(screen.route) {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            selectedIconColor = NeonCyan,
                                            unselectedIconColor = Color.Gray,
                                            indicatorColor = Color.Transparent
                                        )
                                    )
                                }
                            }
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Dungeon.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(Screen.Dungeon.route) {
                                val dungeonViewModel: DungeonViewModel = viewModel(
                                    factory = object : ViewModelProvider.Factory {
                                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                            return DungeonViewModel(repository) as T
                                        }
                                    }
                                )
                                DungeonScreen(viewModel = dungeonViewModel)
                            }
                            composable(Screen.Quests.route) {
                                // For simplicity, QuestsScreen still shows all, we could use ViewModel here too
                                QuestsScreen(quests = emptyList()) 
                            }
                            composable(Screen.Progress.route) {
                                ProgressScreen()
                            }
                            composable(Screen.Inventory.route) {
                                InventoryScreen()
                            }
                            composable(Screen.Profile.route) {
                                ProfileScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
