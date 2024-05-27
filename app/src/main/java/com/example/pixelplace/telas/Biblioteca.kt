package com.example.pixelplace.telas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.pixelplace.ui.theme.poppinsFontFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaBiblioteca(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TELA BIBLIOTECA DO APP",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold
        )
    }
}


