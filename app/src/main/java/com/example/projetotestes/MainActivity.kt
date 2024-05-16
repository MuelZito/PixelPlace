package com.example.projetotestes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projetotestes.telas.TelaCadastro
import com.example.projetotestes.telas.TelaLogin
import com.example.projetotestes.ui.theme.ProjetoTestesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoTestesTheme {
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
    ProjetoTestesTheme {
    }
}

