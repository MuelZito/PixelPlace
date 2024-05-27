package com.example.pixelplace.telas

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pixelplace.entities.Usuario
import com.example.pixelplace.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro(navController: NavController) {
    var nomeUsuario by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha1 by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    val contexto = LocalContext.current
    val apiService = ApiClient.apiService


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0XFF3E3E3E)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//            Text(
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .padding(start = 55.dp),
//                text = "CADASTRE-SE",
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 24.sp,
//                color = Color.White
//
//            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 60.dp, bottom = 10.dp),
                text = "Nome de Usuário",
                color = Color.White
            )

            OutlinedTextField(
                value = nomeUsuario,
                onValueChange = { nomeUsuario = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    focusedContainerColor = Color(0XFF6E6F74),
                    unfocusedContainerColor = Color(0XFF6E6F74),
                    focusedBorderColor = Color(0XFF6E6F74)
                )
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 55.dp, bottom = 10.dp),
                text = "Endereço de e-mail",
                color = Color.White
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0XFF6E6F74),
                    unfocusedContainerColor = Color(0XFF6E6F74),
                    focusedBorderColor = Color(0XFF6E6F74)
                )
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 55.dp, bottom = 10.dp),
                text = "Digite sua Senha",
                color = Color.White
            )
            OutlinedTextField(
                value = senha1,
                onValueChange = { senha1 = it },
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                        Icon(
                            imageVector = if (senhaVisivel) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            tint = Color.White,
                            contentDescription = if (senhaVisivel) "Esconder senha" else "Mostrar senha"
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0XFF6E6F74),
                    unfocusedContainerColor = Color(0XFF6E6F74),
                    focusedBorderColor = Color(0XFF6E6F74)
                )
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp)
            )
            Button(
                modifier = Modifier
                    .size(width = 240.dp, height = ButtonDefaults.MinHeight),
                onClick = {
                    val usuario = Usuario(null, nomeUsuario, email, senha1, null, null)
                    apiService.inserirUsuario(usuario).enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            if (response.isSuccessful) {
                                navController.navigate("login")
                            } else {
                                Toast.makeText(
                                    contexto,
                                    "Não foi possivel cadastrar",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            Toast.makeText(contexto, "Erro na conexão", Toast.LENGTH_SHORT)
                                .show()
                            Log.d("Conexao", t.toString())

                        }
                    })
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2596BE)),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Cadastrar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
            Text(
                text = "Já tem uma conta?",
                color = Color.White,
                fontSize = 22.sp
            )
            Text(modifier = Modifier
                .clickable { navController.navigate(AppDestinos.Login.rota) }
                .padding(top = 5.dp),
                text = "iniciar sessão",
                color = Color(0xFF1992FE),
                textDecoration = TextDecoration.Underline
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun TelaCadastroPreview() {
    TelaCadastro(navController = rememberNavController())
}

