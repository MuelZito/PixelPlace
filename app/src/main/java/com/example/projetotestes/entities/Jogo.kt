package com.example.projetotestes.entities

import java.time.LocalDate


data class Jogo(
    val idJogo: Int?,
    val nome: String,
    var imagem: ByteArray,
    val descricao: String,
    val categoria: String,
    val preco: Double,
    val desconto: Double,
    val data_lancamento: LocalDate,
    val numero_avaliacao: Int,
    val numero_estrelas: Int,
    val desenvolvedora: String
)
