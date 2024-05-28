package com.example.pixelplace.entities


data class Jogo(
    val idJogo: Int?,
    val nome: String,
    var imagem: String,
    val descricao: String,
    val categoria: String,
    val preco: Double,
    val desconto: Double,
    val data_lancamento: String,
    val numero_avaliacao: Int,
    val numero_estrelas: Int,
    val desenvolvedora: String
)
