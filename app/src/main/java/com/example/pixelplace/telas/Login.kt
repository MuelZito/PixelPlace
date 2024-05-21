package com.example.pixelplace.telas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import com.example.pixelplace.ui.theme.poppinsFontFamily
import com.example.pixelplace.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
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
                    text = "Iniciar Sessão",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = Color.White,

                    )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 50.dp, bottom = 10.dp),
                    text = "INICIAR SESSÃO COM O EMAIL",
                    color = Color(0XFF1992FE),
                    textDecoration = TextDecoration.Underline
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
                        .padding(14.dp)
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 50.dp, bottom = 10.dp),
                    text = "SENHA",
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
                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 35.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(

                        checked = isChecked,
                        onCheckedChange = {
                            isChecked = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.White,
                            checkedColor = Color(0XFF6E6F74),
                            uncheckedColor = Color(0XFF6E6F74)
                        )
                    )
                    Text(text = "Lembre-me", color = Color.LightGray)


                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Button(
                    modifier = Modifier
                        .size(width = 240.dp, height = ButtonDefaults.MinHeight),
                    onClick = { /* Perform registration action here */ },
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
                        .padding(10.dp)
                )

                Text(
                    modifier = Modifier
                        .clickable {/*Funçao quando clicar*/ }
                        .padding(top = 5.dp),
                    text = "Não consigo iniciar a sessão",
                    color = Color.LightGray,
                    textDecoration = TextDecoration.Underline
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(70.dp)
                )

                Text(
                    text = "Não tem uma conta?",
                    color = Color.White,
                    fontSize = 22.sp
                )
                Text(
                    modifier = Modifier
                        .clickable { navController.navigate("cadastro") }
                        .padding(top = 5.dp),
                    text = "Cadastrar-se",
                    color = Color(0xFF1992FE),
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun TelaLoginPreview() {
//    TelaLogin()
//}