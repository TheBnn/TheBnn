package com.example.bagstash.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun JournalScreen() {
    CenterText("Журнал (в разработке)")
}

@Composable
fun DistributionScreen() {
    CenterText("Распределение (в разработке)")
}

@Composable
fun ArchiveScreen() {
    CenterText("Архив (в разработке)")
}

@Composable
fun SettingsScreen() {
    CenterText("Настройки (в разработке)")
}

@Composable
private fun CenterText(text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text)
    }
}

