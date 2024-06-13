package com.example.pixelplace.telas

import JogoViewModel
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.pixelplace.components.CardJogoCarrinho
import com.example.pixelplace.ui.theme.poppinsFontFamily

@Composable
fun TelaCarrinho(viewModel: JogoViewModel = viewModel()) {
    val cartState = viewModel.carrinho.collectAsState()
    val navController = rememberNavController()

    Log.d("TelaCarrinho", "Tela do Carrinho carregada")
    Log.d("TelaCarrinho", "Itens no carrinho: ${cartState.value.size}")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0XFF3E3E3E)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cartState.value) { jogo ->
                    Log.d("TelaCarrinho", "Exibindo jogo no carrinho: ${jogo.nome}")
                    CardJogoCarrinho(
                        jogo = jogo,
                        removerCarrinho = { viewModel.removerCarrinho(jogo) })
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total Estimado",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Text(
                        text = "R$ ${viewModel.getPrecoTotal()}",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                       // Log.d("TelaCarrinho", "Botão comprar clicado")
                 viewModel.comprarJogos()
                        //Log.d("TelaCarrinho", "Função comprarJogos chamada")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF2596BE)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Comprar",
                        fontFamily = poppinsFontFamily
                    )
                }


            }
        }
    }
}