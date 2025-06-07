package com.example.packagingapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    onNewSession: () -> Unit = {},
    onOpenJournal: () -> Unit = {},
    onAllocation: () -> Unit = {},
    onArchive: () -> Unit = {},
    onSettings: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainMenuCard(text = stringResource(R.string.main_new_session), onClick = onNewSession)
        MainMenuCard(text = stringResource(R.string.main_open_journal), onClick = onOpenJournal)
        MainMenuCard(text = stringResource(R.string.main_allocation), onClick = onAllocation)
        MainMenuCard(text = stringResource(R.string.main_archive), onClick = onArchive)
        MainMenuCard(text = stringResource(R.string.main_settings), onClick = onSettings)
    }
}

@Composable
private fun MainMenuCard(text: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors()
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = text)
        }
    }
}
