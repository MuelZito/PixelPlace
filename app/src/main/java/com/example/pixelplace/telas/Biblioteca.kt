package com.example.pixelplace.telas

import JogoViewModel
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplace.components.CardBiblioteca


@Composable
fun TelaBiblioteca(viewModel: JogoViewModel = viewModel()) {
    val libraryState = viewModel.jogos.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0XFF3E3E3E)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(libraryState.value) { jogo ->
                Log.d("TelaBiblioteca", "Exibindo jogo na biblioteca: ${jogo.nome}")
                CardBiblioteca(
                    jogo = jogo
                )
            }
        }
    }
}


