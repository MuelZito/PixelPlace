package com.example.pixelplace.network

import com.example.pixelplace.entities.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/ServicesUsuario")
    fun inserirUsuario(@Body usuario: Usuario): Call<Void>

}