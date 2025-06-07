package com.example.bagstash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bagstash.ui.theme.BagStashTheme
import com.example.bagstash.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BagStashTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SpecScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SpecScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    // Load specification text once
    val spec = remember {
        context.resources.openRawResource(R.raw.technical_spec)
            .bufferedReader()
            .use { it.readText() }
    }
    val scrollState = rememberScrollState()
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = spec,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BagStashTheme {
        SpecScreen()
    }
}
