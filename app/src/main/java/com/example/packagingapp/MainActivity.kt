package com.example.packagingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackagingAppTheme {
                Surface {
                    Greeting("PackagingApp")
                }
            }
        }
    }
}

@Composable
fun Greeting(text: String) {
    Text(text = "Hello $text")
}

@Preview
@Composable
fun GreetingPreview() {
    PackagingAppTheme {
        Greeting("Preview")
    }
}
