package com.soloxp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import com.soloxp.ui.viewmodel.*
import com.soloxp.ui.viewmodel.ProgressViewModel
import com.soloxp.data.repository.SoloXpRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repo = (application as SoloXpApplication).repository
        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(primary = NeonCyan, background = DeepBlack, surface = DeepBlack),
                typography = Typography
            ) {
                MainContent(repo)
            }
        }
    }
}

@Composable
fun MainContent(repository: SoloXpRepository) {
    val mainViewModel: MainViewModel = viewModel(factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(repository) as T
    })
    val startupState by mainViewModel.startupState.collectAsState()
    val navController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        when (startupState) {
            is AppStartupState.Loading -> LoadingScreen()
            is AppStartupState.OnboardingRequired -> {
                val onboardingViewModel: OnboardingViewModel = viewModel(factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T = OnboardingViewModel(repository) as T
                })
                OnboardingScreen(viewModel = onboardingViewModel, onFinish = { mainViewModel.completeOnboarding() })
            }
            is AppStartupState.DashboardReady -> Dashboard(repository, navController)
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize().background(DeepBlack), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = NeonCyan)
    }
}

@Composable
fun Dashboard(repository: SoloXpRepository, navController: androidx.navigation.NavHostController) {
    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF121214), contentColor = Color.White) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavItems.forEach { screen ->
                    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    NavigationBarItem(
                        icon = { Icon(imageVector = screen.icon, contentDescription = screen.title, tint = if (selected) NeonCyan else Color.Gray) },
                        label = { Text(text = screen.title, color = if (selected) NeonCyan else Color.Gray) },
                        selected = selected,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(selectedIconColor = NeonCyan, unselectedIconColor = Color.Gray, indicatorColor = Color.Transparent)
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = Screen.Dungeon.route, modifier = Modifier.padding(innerPadding)) {
            composable(Screen.Dungeon.route) {
                val vm: DungeonViewModel = viewModel(factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T = DungeonViewModel(repository) as T
                })
                DungeonScreen(viewModel = vm)
            }
            composable(Screen.Quests.route) { QuestsScreen(quests = emptyList()) }
            composable(Screen.Progress.route) { 
                val vm: ProgressViewModel = viewModel(factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T = ProgressViewModel(repository) as T
                })
                ProgressScreen(viewModel = vm)
            }
            composable(Screen.Inventory.route) { 
                val vm: InventoryViewModel = viewModel(factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T = InventoryViewModel(repository) as T
                })
                InventoryScreen(viewModel = vm) 
            }
            composable(Screen.Profile.route) {
                val vm: ProfileViewModel = viewModel(factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T = ProfileViewModel(repository) as T
                })
                ProfileScreen(viewModel = vm)
            }
        }
    }
}
