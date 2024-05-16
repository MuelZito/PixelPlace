package com.example.projetotestes.entities

data class Usuario(
    val idUsuario: String?,
    val nomeUsuario: String,
    val email: String,
    val senha: String,
    var imagem: ByteArray?,
    val isAdm: String
)
