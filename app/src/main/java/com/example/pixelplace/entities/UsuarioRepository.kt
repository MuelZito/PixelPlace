package com.example.pixelplace.entities

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import com.example.pixelplace.network.ApiClient
import com.example.pixelplace.telas.AppDestinos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioRepository {
    fun realizarLogin(contexto: Context, email: String, senha: String, navController: NavController) {
        val apiService = ApiClient.apiService

        val call = apiService.login(email, senha)
        call.enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    val usuario = response.body()
                    if (usuario != null) {
                        // Usuário autenticado com sucesso, navegue para a próxima tela
                        navController.navigate(AppDestinos.Inicial.rota)
                        Toast.makeText(contexto, "Entrando...", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(contexto, "Email ou senha estão errados", Toast.LENGTH_SHORT).show()

                    }
                } else {
                    Toast.makeText(contexto, response.message(), Toast.LENGTH_SHORT).show()
                    Log.d("Login", response.toString())
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(contexto, "Erro na conexão", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun cadastrarUsuario(context: Context, usuario: Usuario, navController: NavController) {
        val apiService = ApiClient.apiService
        val call = apiService.inserirUsuario(usuario)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show()
                    navController.navigate(AppDestinos.Login.rota)
                } else {
                    Toast.makeText(context, "Não foi possível cadastrar", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(context, "Erro na conexão", Toast.LENGTH_SHORT).show()
                Log.d("Conexao", t.toString())
            }
        })
    }
}
