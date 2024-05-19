package com.example.pixelplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pixelplace.telas.TelaCadastro
import com.example.pixelplace.telas.TelaLogin
import com.example.pixelplace.ui.theme.PixelPlaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixelPlaceTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { TelaLogin(navController) }
                    composable("cadastro") { TelaCadastro(navController) }
                }
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

