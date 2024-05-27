package com.example.pixelplace.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextAlign
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

                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    text = categoria,
                    color = Color(0xFFFEFEFE),
                    fontFamily = poppinsFontFamily,
                    fontSize = 10.sp,
                )

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .shadow(elevation = 10.dp, RoundedCornerShape(12.dp),ambientColor = Color(0xFF2596BE), spotColor = Color(0xFF2596BE), clip = false)
                        .size(width = 150.dp, height = 35.dp),
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

@Preview(showBackground = true)
@Composable
fun CardJogoPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CardJogo(
            "Minecraft",
            "Mojang",
            "Sobrevivência",
            "R$75.89"
        )
    }
}