package com.example.bagstash.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { /* TODO create new session */ }, modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Новый учёт")
        }
        Button(onClick = { navController.navigate(Screen.Journal.route) }, modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Открыть дневной журнал")
        }
        Button(onClick = { navController.navigate(Screen.Distribution.route) }, modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Распределение по машинам")
        }
        Button(onClick = { navController.navigate(Screen.Archive.route) }, modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Архив")
        }
        Button(onClick = { navController.navigate(Screen.Settings.route) }, modifier = Modifier.padding(bottom = 8.dp)) {
            Text("Настройки")
        }
    }
}

