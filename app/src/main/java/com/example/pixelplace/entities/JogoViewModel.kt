package com.example.pixelplace.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixelplace.entities.Jogo
import com.example.pixelplace.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JogoViewModel : ViewModel() {
    private val _jogos = MutableStateFlow<List<Jogo>>(emptyList())
    val jogos: StateFlow<List<Jogo>> = _jogos

    init {
        fetchJogos()
    }

    private fun fetchJogos() {
        viewModelScope.launch {
            try {
                // Mudança para a thread de IO
                val response = withContext(Dispatchers.IO) {
                    ApiClient.apiService.getJogos().execute()
                }
                if (response.isSuccessful) {
                    _jogos.value = response.body() ?: emptyList()
                    Log.d("JogoViewModel", "Jogos carregados com sucesso")
                } else {
                    Log.e("JogoViewModel", "Erro ao carregar jogos: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("JogoViewModel", "Exceção ao carregar jogos", e)
            }
        }
    }
}
