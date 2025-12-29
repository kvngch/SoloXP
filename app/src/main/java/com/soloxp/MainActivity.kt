package com.soloxp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.soloxp.data.local.SeedData
import com.soloxp.ui.Screen
import com.soloxp.ui.screen.DungeonScreen
import com.soloxp.ui.screen.OnboardingScreen
import com.soloxp.ui.theme.Typography
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import com.soloxp.ui.bottomNavItems
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(),
                typography = Typography
            ) {
                var showOnboarding by remember { mutableStateOf(true) }
                val navController = rememberNavController()

                if (showOnboarding) {
                    OnboardingScreen(onFinish = { showOnboarding = false })
                } else {
                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                bottomNavItems.forEach { screen ->
                                    NavigationBarItem(
                                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                                        label = { Text(screen.title) },
                                        selected = false, // TODO: Handle selection state
                                        onClick = { navController.navigate(screen.route) }
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
                                DungeonScreen(quests = SeedData.getInitialQuests().take(3))
                            }
                            // Add other routes here...
                        }
                    }
                }
            }
        }
    }
}
