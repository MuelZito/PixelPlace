package com.example.pixelplace.telas

sealed class AppDestinos(val rota: String){
    object Inicial: AppDestinos("inicial")
    object Biblioteca: AppDestinos("biblioteca")
    object Cadastro: AppDestinos("cadastro")
    object Login: AppDestinos("login")
}
