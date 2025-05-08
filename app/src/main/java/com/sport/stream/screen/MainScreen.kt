package com.sport.stream.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.sport.stream.BottomNavigationBar
import com.sport.stream.HomeScreen
import com.sport.stream.LiveScreen
import com.sport.stream.ProfileScreen
import com.sport.stream.Screen
import com.sport.stream.TestDetailScreen
import com.sport.stream.screen.home.compoment.SeeAllScreen
import com.sport.stream.screen.home.model.HomeViewModel
import com.sport.stream.ui.theme.TestAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    // Lấy route hiện tại
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val homeModel: HomeViewModel = viewModel()

    val playerRunning by remember(currentRoute) {
        derivedStateOf { currentRoute == Screen.Live.rout }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        text = when (currentRoute) {
//                            Screen.Home.rout -> "Trang chủ"
//                            Screen.Live.rout -> "Trực tiếp"
//                            Screen.Profile.rout -> "Hồ sơ"
//                            else -> ""
//                        }
//                    )
//                }
//            )
        },
        bottomBar = {
            if (!playerRunning){
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->

        val graph =
            navController.createGraph(startDestination = Screen.Home.rout) {
                composable(route = Screen.Home.rout) {
                    HomeScreen(navController,homeModel)
                }
                composable(route = Screen.Live.rout) {
                    LiveScreen()
                }
                composable(route = Screen.Profile.rout) {
                    ProfileScreen()
                }

                composable(route = Screen.SeeAllMatch.rout) {
                    SeeAllScreen(matches = homeModel.hotMatches, onBack = {
                        navController.popBackStack()
                    },  onMatchClick = { match ->
                        println("Clicked match on All Screen: ${match.homeTeam} vs ${match.awayTeam}")
                        navController.navigate(Screen.Live.rout)
                    })
                }


                // 👇 DetailScreen nhận tham số
                composable(route = "detail/{itemIndex}") { backStackEntry ->
                    val itemIndex = backStackEntry.arguments?.getString("itemIndex")
                    TestDetailScreen(itemIndex)
                }
            }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    TestAppTheme {
        MainScreen()
    }
}