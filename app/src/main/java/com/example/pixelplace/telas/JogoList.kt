// Na sua função Composable
package com.example.pixelplace.telas

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplace.components.CardJogoDestaque
import com.example.pixelplace.viewmodel.JogoViewModel

@Composable
fun JogoListScreen(viewModel: JogoViewModel = viewModel()) {
    val jogos by viewModel.jogos.collectAsState()

    Log.d("JogoListScreen", "Número de jogos carregados: ${jogos.size}")

    LazyColumn {
        items(jogos) { jogo ->
            Log.d("JogoListScreen", "Exibindo jogo: ${jogo.nome}")
            CardJogoDestaque(jogo = jogo)
        }
    }
}
