package com.sport.stream

sealed class Screen(val rout: String) {
    object Auth: Screen("auth_screen")
    object Home: Screen("home_screen")
    object Live: Screen("live_screen")
    object Profile: Screen("profile_screen")
    object SeeAllMatch: Screen("see_all_match_screen")
}