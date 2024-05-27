package com.example.pixelplace.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.pixelplace.ui.theme.poppinsFontFamily

@Composable
fun TelaInicial() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "TELA INICIAL DO APP",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold
        )
    }

}

@Preview
@Composable
fun TeleInicialPreview() {
    TelaInicial()
}