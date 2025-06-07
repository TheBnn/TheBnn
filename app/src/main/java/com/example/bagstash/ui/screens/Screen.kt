package com.example.bagstash.ui.screens

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Journal : Screen("journal")
    object Distribution : Screen("distribution")
    object Archive : Screen("archive")
    object Settings : Screen("settings")
}
