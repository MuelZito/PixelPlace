package com.example.pixelplace.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pixelplace.R
import com.example.pixelplace.ui.theme.poppinsFontFamily

@Composable
fun CardJogo(titulo: String, desenvolvedora: String, categoria: String, preco: String) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(290.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3E3E3E))
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.minecraft),
                contentDescription = "Imagem Card",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = titulo,
                    color = Color(0xFFFEFEFE),
                    fontFamily = poppinsFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = desenvolvedora,
                    color = Color(0xFF979494),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )

                Row(
                    modifier = Modifier
                        .padding(top = 0.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("SandBox", "Sobrevivencia").forEach { categoria ->
                        Box(
                            modifier = Modifier
                                .padding(top = 6.dp) // padding externo ao Box
                                .background(
                                    Color.White.copy(alpha = 0.3f),
                                    RoundedCornerShape(3.dp)
                                )
                                .padding(
                                    horizontal = 4.dp,
                                    vertical = 2.dp
                                ) // padding interno ao Box
                        ) {
                            Text(
                                text = categoria,
                                color = Color(0xFFFEFEFE),
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .shadow(
                            elevation = 10.dp,
                            RoundedCornerShape(12.dp),
                            ambientColor = Color(0xFF2596BE),
                            spotColor = Color(0xFF2596BE),
                            clip = false
                        )
                        .size(width = 150.dp, height = 40.dp),
                    //elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2596BE)),
                    shape = RoundedCornerShape(12.dp)

                ) {
                    Text(
                        text = preco,
                        fontSize = 12.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

    }
}

@Composable
fun CardJogoDestaque(titulo: String,categoria: String, preco: String) {
    Card(
        modifier = Modifier
            .width(330.dp)
            .height(250.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3E3E3E))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.minecraft),
                contentDescription = "Imagem Card",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(10.dp)), // ajustado para coincidir com a borda do Card
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
            ) {
                Text(
                    text = titulo,
                    color = Color(0xFFFEFEFE),
                    fontFamily = poppinsFontFamily,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("SandBox", "Sobrevivencia").forEach { categoria ->
                        Box(
                            modifier = Modifier
                                .padding(top = 6.dp) // padding externo ao Box
                                .background(
                                    Color.White.copy(alpha = 0.3f),
                                    RoundedCornerShape(3.dp)
                                )
                                .padding(
                                    horizontal = 4.dp,
                                    vertical = 2.dp
                                ) // padding interno ao Box
                        ) {
                            Text(
                                text = categoria,
                                color = Color(0xFFFEFEFE),
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = preco,
                        color = Color(0xFFFEFEFE),
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )

            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun CardJogoPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CardJogo("Minecraft", "Mojang", "", "R$56.90")
    }
}

@Preview(showBackground = true)
@Composable
fun CardJogoDestaquePreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CardJogoDestaque("Minecraft", "", "R$ 76.90")
    }
}


