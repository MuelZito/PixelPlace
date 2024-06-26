package com.example.pixelplace.network

import com.example.pixelplace.entities.Jogo
import com.example.pixelplace.entities.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("/api/ServicesUsuario")
    fun inserirUsuario(@Body usuario: Usuario): Call<Void>

    @GET("/api/ServicesJogo")
    fun getJogos(): Call<List<Jogo>>

    @GET("/api/ServicesJogo/{id}")
    fun getJogoId(@Path("id")id: Int): Call<Jogo>

    @GET("api/ServicesUsuario/Login")
    fun login(@Query("email") email: String, @Query("senha") senha: String): Call<Usuario>

}