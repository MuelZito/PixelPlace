
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

    private val _carrinho = MutableStateFlow<List<Jogo>>(emptyList())
    val carrinho: StateFlow<List<Jogo>> = _carrinho

    private val _listaDesejo = mutableSetOf<Jogo>()
    val listaDesejo: Set<Jogo> get() = _listaDesejo

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchJogos()
    }

    private fun fetchJogos() {
        viewModelScope.launch {
            _isLoading.value = true
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
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun estaNoCarrinho(jogo: Jogo): Boolean {
        return _carrinho.value.any { it.idJogo == jogo.idJogo }
    }

    fun addCarrinho(jogo: Jogo): Boolean {
        return if (!estaNoCarrinho(jogo)) {
            _carrinho.value = _carrinho.value + jogo
            Log.d("JogoViewModel", "Jogo adicionado ao carrinho: ${jogo.nome}")
            true
        } else {
            Log.d("JogoViewModel", "Jogo já está no carrinho: ${jogo.nome}")
            false
        }
    }

    fun removerCarrinho(jogo: Jogo) {
        _carrinho.value = _carrinho.value - jogo
    }

    fun getPrecoTotal(): Double {
        return _carrinho.value.sumOf { it.preco }
    }
    fun comprarJogos() {
        _carrinho.value = emptyList()
        Log.d("JogoViewModel", "Jogos comprados e carrinho limpo")
    }





}
