package com.example.pixelplace.entities

data class Usuario(
    val idUsuario: Int?,
    val nomeUsuario: String,
    val email: String,
    val senha: String,
    var imagem: String?,
    val isAdm: String
)

