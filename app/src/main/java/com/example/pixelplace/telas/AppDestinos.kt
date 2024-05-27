package com.example.pixelplace.telas

sealed class AppDestinos(val rota: String){

    object Cadastro: AppDestinos("cadastro")
    object Login: AppDestinos("login")
}
