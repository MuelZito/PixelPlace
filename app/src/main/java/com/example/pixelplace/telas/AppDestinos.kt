package com.example.pixelplace.telas

sealed class AppDestinos(val rota: String, val titulo: String){
    object Inicial: AppDestinos("inicial","Inicial")
    object Biblioteca: AppDestinos("biblioteca","Biblioteca")
    object Cadastro: AppDestinos("cadastro","Cadastro")
    object Login: AppDestinos("login","Login")
    object Carrinho: AppDestinos("carrinho","Carrinho de compras")
}
