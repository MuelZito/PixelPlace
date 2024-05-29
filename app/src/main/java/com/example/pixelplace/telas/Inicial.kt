package com.example.pixelplace.telas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplace.components.CardJogo
import com.example.pixelplace.components.CardJogoDestaque
import com.example.pixelplace.viewmodel.JogoViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos

@Composable
fun TelaInicial(viewModel: JogoViewModel = viewModel()) {
    val jogosState = viewModel.jogos.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        item {
            if (jogosState.value.isNotEmpty()) {
                // Exibe o primeiro jogo como destaque
                val jogoDestaque = jogosState.value.first()
                CardJogoDestaque(jogo = jogoDestaque)

                // Espaço entre o card de destaque e o texto
                Spacer(modifier = Modifier.height(16.dp))

                // Texto "Jogos que você pode gostar"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Jogos que você pode gostar",
                        fontSize = 18.sp
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Espaço entre o texto e a lista de jogos
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        item {
            // Exibe os demais jogos na grade
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .height(500.dp), // Definindo uma altura para LazyVerticalGrid
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(jogosState.value.drop(1)) { jogo ->
                    CardJogo(jogo = jogo)
                }
            }
        }
    }
}
