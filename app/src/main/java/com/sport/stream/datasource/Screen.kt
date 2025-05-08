package com.sport.stream

sealed class Screen(val rout: String) {
    object Home: Screen("home_screen")
    object Live: Screen("live_screen")
    object Profile: Screen("profile_screen")
}