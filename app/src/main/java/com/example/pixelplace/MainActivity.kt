package com.example.pixelplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pixelplace.components.AppNavigationDrawer
import com.example.pixelplace.ui.theme.PixelPlaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixelPlaceTheme {
               AppNavigationDrawer()
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    PixelPlaceTheme {
    }
}

