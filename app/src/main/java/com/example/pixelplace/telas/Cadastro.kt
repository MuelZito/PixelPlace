package com.example.pixelplace.telas

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
import com.example.pixelplace.entities.UsuarioRepository
import com.example.pixelplace.ui.theme.poppinsFontFamily


@Composable
fun TelaCadastro(navController: NavController) {
    var nomeUsuario by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    val contexto = LocalContext.current
    val usuarioRepository = UsuarioRepository()


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0XFF3E3E3E)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
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
                fontFamily = poppinsFontFamily,
                color = Color.White
            )

            OutlinedTextField(
                value = nomeUsuario,
                onValueChange = { nomeUsuario = it },
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
                text = "Endereço de e-mail",
                fontFamily = poppinsFontFamily,
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
                fontFamily = poppinsFontFamily,
                color = Color.White
            )
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                        Icon(
                            imageVector = if (senhaVisivel) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            tint = Color.White,
                            contentDescription = null
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
                    if (nomeUsuario.isNotBlank() && email.isNotBlank() && senha.isNotBlank()) {
                        val usuario = Usuario(null, nomeUsuario, email, senha, null, "")
                        usuarioRepository.cadastrarUsuario(contexto, usuario, navController)
                    } else {
                        Toast.makeText(contexto, "Preencha todos os campos", Toast.LENGTH_SHORT).show()

                    }

                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2596BE)),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Cadastrar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
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
                color = Color.Gray,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
            Text(modifier = Modifier
                .clickable { navController.navigate(AppDestinos.Login.rota) }
                .padding(top = 5.dp),
                text = "iniciar sessão",
                fontFamily = poppinsFontFamily,
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

