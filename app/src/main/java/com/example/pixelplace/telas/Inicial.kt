package com.example.pixelplace.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplace.viewmodel.JogoViewModel

@Composable
fun TelaInicial(viewModel: JogoViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Alterar para Top para os jogos aparecerem abaixo do texto
    ) {

        JogoListScreen(viewModel = viewModel)
    }
}

@Preview
@Composable
fun TelaInicialPreview() {
    TelaInicial()
}
