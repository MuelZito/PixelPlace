package com.example.pixelplace.telas

import JogoViewModel
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pixelplace.components.CardJogo
import com.example.pixelplace.components.CardJogoDestaque
import com.example.pixelplace.ui.theme.poppinsFontFamily

@Composable
fun TelaInicial(viewModel: JogoViewModel = viewModel()) {
    val jogosState = viewModel.jogos.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()
    val contexto = LocalContext.current


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0XFF3E3E3E)
    ) {
        if (isLoading.value) {
            // Exibir indicador de carregamento enquanto os dados estão sendo carregados
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
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
                        CardJogoDestaque(jogo = jogoDestaque, addCarrinho = {jogo->
                            val added = viewModel.addCarrinho(jogo)
                            if (added) {
                                Toast.makeText(contexto, "${jogo.nome} foi adicionado ao carrinho.", Toast.LENGTH_SHORT).show()
                                Log.d("TelaInicial", "Adicionar ao carrinho: ${jogo.nome}")
                            } else {
                                Toast.makeText(contexto, "${jogo.nome} já está no carrinho.", Toast.LENGTH_SHORT).show()
                                Log.d("TelaInicial", "Jogo já está no carrinho: ${jogo.nome}")
                            }
                            Log.d("TelaInicial", "Adicionar ao carrinho: ${jogo.nome}")
                        })
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Jogos que você pode gostar",
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                            Icon(
                                imageVector = Icons.Filled.ArrowForwardIos,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        // Espaço entre o texto e a lista de jogos
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                item {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxSize()
                            .height(500.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(jogosState.value.drop(1)) { jogo ->
                            CardJogo(jogo = jogo, addCarrinho = {
                                val added = viewModel.addCarrinho(jogo)
                                if (added) {
                                    Toast.makeText(contexto, "${jogo.nome} foi adicionado ao carrinho.", Toast.LENGTH_SHORT).show()
                                    Log.d("TelaInicial", "Adicionar ao carrinho: ${jogo.nome}")
                                } else {
                                    Toast.makeText(contexto, "${jogo.nome} já está no carrinho.", Toast.LENGTH_SHORT).show()
                                    Log.d("TelaInicial", "Jogo já está no carrinho: ${jogo.nome}")
                                }
                                Log.d("TelaInicial", "Adicionar ao carrinho: ${it.nome}")
                            })
                        }
                    }
                }
            }
        }
    }
}
