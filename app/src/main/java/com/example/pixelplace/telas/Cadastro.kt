package com.example.pixelplace.telas

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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pixelplace.R
import com.example.pixelplace.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro(navController: NavController) {
    var nomeUsuario by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "PixelPlace",
                        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.topBarCor),
                    titleContentColor = Color.White,

                    ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            tint = Color.White,
                            contentDescription = null
                        )
                    }
                },

                )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0XFF3E3E3E)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 55.dp),
                    text = "CADASTRE-SE",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = Color.White,

                    )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp)
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
                    value = senha,
                    onValueChange = { senha = it },
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
                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 55.dp, bottom = 10.dp),
                    text = "Confirme sua Senha ",
                    color = Color.White
                )
                OutlinedTextField(
                    value = confirmarSenha,
                    onValueChange = { confirmarSenha = it },
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
                        .padding(28.dp)
                )
                Button(
                    modifier = Modifier
                        .size(width = 240.dp, height = ButtonDefaults.MinHeight),
                    onClick = {/*Açao para ir para tela de login e cadastrar*/ },
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
                    .clickable {navController.navigate("login")}
                    .padding(top = 5.dp),
                    text = "iniciar sessão",
                    color = Color(0xFF1992FE),
                    textDecoration = TextDecoration.Underline
                )
            }
        }

    }


}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun TelaCadastroPreview() {
//    val navController = rememberNavController()
//    TelaCadastro(navController = navController)
//}